COMPONENT=BaseStationC

# disable ACK on radio for speedup
CFLAGS += -DCC2420_NO_ACKNOWLEDGEMENTS
CFLAGS += -DCC2420_NO_ADDRESS_RECOGNITION


INCLUDES= -I..               \
          -I../Reset		 \
          -I../AMTap
          
# include own platform.h with initialization redefinition
# for IRIS nodes to perform correct restart
-include platform.h

include $(MAKERULES)

