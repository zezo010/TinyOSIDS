/*
 * Copyright (c) 2008 Dimas Abreu Dutra
 * All rights reserved
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * - Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the
 *   distribution.
 * - Neither the name of the Stanford University nor the names of
 *   its contributors may be used to endorse or promote products derived
 *   from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * ``AS IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL DIMAS ABREU
 * DUTRA OR HIS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */

/**
 * @author Dimas Abreu Dutra
 */

#include "../RssiDemoMessages.h"
#include "message.h"
#include "../Reset/Reset.h"
#include "Ctp.h"

configuration RssiBaseAppC {
} implementation {
  components BaseStationC;
  components RssiBaseC as App;
  
  // need to have this component to be able to work with commands send via serial
  components SerialActiveMessageC as Serial;
  
  components ActiveMessageC, MainC, LedsC;  

#ifdef CC2420_HW_SECURITY
  components new SecAMSenderC(AM_MULTIPINGRESPONSEMSG) as PingMsgSender;
#else
  components new AMSenderC(AM_MULTIPINGRESPONSEMSG) as PingMsgSender;
#endif

  components new AMSenderC(AM_COMMANDMSG) as RadioCmdAMSend;

  //components new AMSenderC(AM_PINGMSG) as PingMsgSender;
  // RSSI report send timer
  components new TimerMilliC() as SendTimer;
  // keep alive send timer
  components new TimerMilliC() as AliveTimer;
  // send timer for repeated sending of pings
  components new TimerMilliC() as PingTimer;
  
  // RSSI reading queue
  components new QueueC(MultiPingResponseReportStruct_t, RSSI_QUEUE_LEN) as RSSIQueue;
  
  components ResetC;
  
  /**************** NOISE FLOOR READING ****************/
  // repeatedly noise floor reading timer
  components new TimerMilliC() as NoiseFloorTimer;

#ifdef __CC2420_H__
  components CC2420ActiveMessageC;
  App -> CC2420ActiveMessageC.CC2420Packet;
//  App.CC2420PacketBody -> CC2420Packet.CC2420PacketBody;
  
#ifdef CC2420_HW_SECURITY 
	components CC2420KeysC;
	App.CC2420Security -> PingMsgSender;
	App.CC2420Keys -> CC2420KeysC;
#endif
  
   // setting channel
  components CC2420RadioC;
  components CC2420ControlC;
  components CC2420ControlP;
  App -> CC2420ControlC.CC2420Config;
  App.ReadRssi -> CC2420ControlP;
#elif  defined(PLATFORM_IRIS)
  components  RF230ActiveMessageC, PacketField;
  App -> RF230ActiveMessageC.PacketRSSI;
#elif defined(TDA5250_MESSAGE_H)
  components Tda5250ActiveMessageC;
  App -> Tda5250ActiveMessageC.Tda5250Packet;
#endif
	
// interceptors for radio messages - may be processed
  App.SimpleRssiMsgIntercept -> BaseStationC.RadioIntercept[AM_RSSIMSG];
  App.CommandMsgIntercept -> BaseStationC.RadioIntercept[AM_COMMANDMSG];
  App.RssiMsgIntercept->BaseStationC.RadioIntercept[AM_MULTIPINGRESPONSEMSG];
  
// MultiPingRequest intercept from radio
  App.MultiPingRadioIntercept -> BaseStationC.RadioIntercept[AM_MULTIPINGMSG];
// MultiPingRequest intercept from serial
  App.MultiPingSerialIntercept -> BaseStationC.SerialIntercept[AM_MULTIPINGMSG];
// serial interceptors - do not forward messages for myself
  App.SerialCommandIntercept->BaseStationC.SerialIntercept[AM_COMMANDMSG];
  
// sending reports to UART via queue
  App.UartAMSend -> BaseStationC.SerialSend[AM_MULTIPINGRESPONSEREPORTMSG];
// sending commands and alive reports  
 App.UartCmdAMSend -> BaseStationC.SerialSend[AM_COMMANDMSG];
// radio command senging
 App.RadioCmdAMSend -> RadioCmdAMSend;
// sending noise floor readings 
 App.UartNoiseAMSend -> BaseStationC.SerialSend[AM_NOISEFLOORREADINGMSG];
// Quick serial sending by pushing to queue
 App.UartQueue -> BaseStationC.SerialQueue;
 App.RSSIQueue -> RSSIQueue;
//MultiPingResponseReportStruct_t 
 
 // split controll notifiers
  App.RadioControl -> BaseStationC.BSRadioControl;
  App.SerialControl -> BaseStationC.BSSerialControl;
  
  App.Boot -> MainC;
  App.SendTimer -> SendTimer;
  App.AliveTimer -> AliveTimer;
  App.PingTimer -> PingTimer;
  
  App.PingMsgSend -> PingMsgSender;
  //App.RadioControl -> ActiveMessageC;
  App.Leds -> LedsC;
  App.Packet -> PingMsgSender;
  App.AMPacket -> PingMsgSender;
  App.Acks -> PingMsgSender;
  
  App.RadioPacket -> ActiveMessageC;
  App.RadioAMPacket -> ActiveMessageC;
  
  App.UartPacket -> Serial;
  App.UartAMPacket -> Serial;
  
  App.InterceptBaseConfig -> BaseStationC.InterceptBaseConfig;
  
  App.Reset -> ResetC;
  
  /**************** NOISE FLOOR READING ****************/
  App.NoiseFloorTimer -> NoiseFloorTimer;
  
  /**************** Collector ****************/   
    components CollectionC as Collector, new CollectionSenderC(AM_CTPRESPONSEMSG);
    
    App.ForwardingControl -> Collector.StdControl;
    App.RoutingInit -> Collector.RoutingInit;
    App.ForwardingInit -> Collector.ForwardingInit;
    App.LinkEstimatorInit -> Collector.LinkEstimatorInit;
    
    App.CtpSend -> CollectionSenderC;
    App.RootControl -> Collector;
  	App.CtpInfo -> Collector;
//    App.CtpCongestion -> Collector;
    App.CollectionPacket -> Collector;
    App.CtpReceive -> Collector.Receive[AM_CTPRESPONSEMSG];

    components RandomC;
    App.Random -> RandomC;
    
    // send timer for repeated sending of CTP messages
  	components new TimerMilliC() as CtpTimer;
  	App.CtpTimer -> CtpTimer;
  	
  	// intercept requests for CTP sending
  	App.CtpRequestSerialIntercept -> BaseStationC.SerialIntercept[AM_CTPSENDREQUESTMSG];
  	
  	// send collected reports
    App.UartCtpReportDataAMSend -> BaseStationC.SerialSend[AM_CTPREPORTDATAMSG];
  	
  	// tapping interface
  	App.AMTap -> BaseStationC.AMTap;
  	
  	// tapping interface from forged message
  	// Since BaseStation does not support radioSending correctly now, we need
  	// to hook send() calls by this way. Needed to set TX power for some messages
  	components ForgedActiveMessageC as FAM;
  	App.AMTapForg -> FAM.AMTap;
  	
  	// do not forward CTP messages, save UART bandwidth
  	App.CtpRoutingIntercept -> BaseStationC.RadioIntercept[AM_CTP_ROUTING];
  	App.CtpDataIntercept -> BaseStationC.RadioIntercept[AM_CTP_DATA];
  	App.CtpDebugIntercept -> BaseStationC.RadioIntercept[AM_CTP_DEBUG];
  	
  	// LOGGER DISABLED TEMPORARILY
  	// Logger produces intensive data streams, if everybody is set to listen to 
  	// everything (snooping, addressDetection=false), it can cause UART queues to 
  	// overflow very quickly, since debug message can be send plenty times for 
  	// only 1 CTP message from 1 node (approx. each routing decision) 
  	
  	App.ForwardControl -> Collector.ForwardControl;
  	
  	// implement debug to see real CTP behavior and routing decisions
  components UARTDebugSenderP as LoggerC;
	LoggerC.UARTSend -> BaseStationC.SerialSend[AM_CTP_DEBUG];
	LoggerC.Boot -> MainC;
	
	components new PoolC(message_t, 5) as CTPDbgPool;
	components new QueueC(message_t*, 5) as CTPDbgQueue;
	LoggerC.SendQueue -> CTPDbgQueue;
	LoggerC.MessagePool -> CTPDbgPool;  	
    Collector.CollectionDebug -> LoggerC;
    App.CtpLoggerControl -> LoggerC.StdControl;
    App.CtpLogger -> LoggerC.CollectionDebug;
//  	
//components DefaultLplC;

//////// TIMESYNC
//App.TimeSyncSend -> BaseStationC.SerialSend[AM_TIMESYNCMSG];
}
