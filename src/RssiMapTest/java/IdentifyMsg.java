/**
 * This class is automatically generated by mig. DO NOT EDIT THIS FILE.
 * This class implements a Java interface to the 'IdentifyMsg'
 * message type.
 */

public class IdentifyMsg extends net.tinyos.message.Message {

    /** The default size of this message type in bytes. */
    public static final int DEFAULT_MESSAGE_SIZE = 19;

    /** The Active Message type associated with this message. */
    public static final int AM_TYPE = 40;

    /** Create a new IdentifyMsg of size 19. */
    public IdentifyMsg() {
        super(DEFAULT_MESSAGE_SIZE);
        amTypeSet(AM_TYPE);
    }

    /** Create a new IdentifyMsg of the given data_length. */
    public IdentifyMsg(int data_length) {
        super(data_length);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new IdentifyMsg with the given data_length
     * and base offset.
     */
    public IdentifyMsg(int data_length, int base_offset) {
        super(data_length, base_offset);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new IdentifyMsg using the given byte array
     * as backing store.
     */
    public IdentifyMsg(byte[] data) {
        super(data);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new IdentifyMsg using the given byte array
     * as backing store, with the given base offset.
     */
    public IdentifyMsg(byte[] data, int base_offset) {
        super(data, base_offset);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new IdentifyMsg using the given byte array
     * as backing store, with the given base offset and data length.
     */
    public IdentifyMsg(byte[] data, int base_offset, int data_length) {
        super(data, base_offset, data_length);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new IdentifyMsg embedded in the given message
     * at the given base offset.
     */
    public IdentifyMsg(net.tinyos.message.Message msg, int base_offset) {
        super(msg, base_offset, DEFAULT_MESSAGE_SIZE);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new IdentifyMsg embedded in the given message
     * at the given base offset and length.
     */
    public IdentifyMsg(net.tinyos.message.Message msg, int base_offset, int data_length) {
        super(msg, base_offset, data_length);
        amTypeSet(AM_TYPE);
    }

    /**
    /* Return a String representation of this message. Includes the
     * message type name and the non-indexed field values.
     */
    public String toString() {
      String s = "Message <IdentifyMsg> \n";
      try {
        s += "  [counter=0x"+Long.toHexString(get_counter())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [nodeId=0x"+Long.toHexString(get_nodeId())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [replyOn=0x"+Long.toHexString(get_replyOn())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [platformId=0x"+Long.toHexString(get_platformId())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [identifyAfterBoot=0x"+Long.toHexString(get_identifyAfterBoot())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [radioQueueLen=0x"+Long.toHexString(get_radioQueueLen())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [serialQueueLen=0x"+Long.toHexString(get_serialQueueLen())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [rssiQueueLen=0x"+Long.toHexString(get_rssiQueueLen())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [failCount=0x"+Long.toHexString(get_failCount())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [command_data_next=";
        for (int i = 0; i < 4; i++) {
          s += "0x"+Long.toHexString(getElement_command_data_next(i) & 0xffff)+" ";
        }
        s += "]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      return s;
    }

    // Message-type-specific access methods appear below.

    /////////////////////////////////////////////////////////
    // Accessor methods for field: counter
    //   Field type: int, unsigned
    //   Offset (bits): 0
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'counter' is signed (false).
     */
    public static boolean isSigned_counter() {
        return false;
    }

    /**
     * Return whether the field 'counter' is an array (false).
     */
    public static boolean isArray_counter() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'counter'
     */
    public static int offset_counter() {
        return (0 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'counter'
     */
    public static int offsetBits_counter() {
        return 0;
    }

    /**
     * Return the value (as a int) of the field 'counter'
     */
    public int get_counter() {
        return (int)getUIntBEElement(offsetBits_counter(), 16);
    }

    /**
     * Set the value of the field 'counter'
     */
    public void set_counter(int value) {
        setUIntBEElement(offsetBits_counter(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'counter'
     */
    public static int size_counter() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'counter'
     */
    public static int sizeBits_counter() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: nodeId
    //   Field type: int, unsigned
    //   Offset (bits): 16
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'nodeId' is signed (false).
     */
    public static boolean isSigned_nodeId() {
        return false;
    }

    /**
     * Return whether the field 'nodeId' is an array (false).
     */
    public static boolean isArray_nodeId() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'nodeId'
     */
    public static int offset_nodeId() {
        return (16 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'nodeId'
     */
    public static int offsetBits_nodeId() {
        return 16;
    }

    /**
     * Return the value (as a int) of the field 'nodeId'
     */
    public int get_nodeId() {
        return (int)getUIntBEElement(offsetBits_nodeId(), 16);
    }

    /**
     * Set the value of the field 'nodeId'
     */
    public void set_nodeId(int value) {
        setUIntBEElement(offsetBits_nodeId(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'nodeId'
     */
    public static int size_nodeId() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'nodeId'
     */
    public static int sizeBits_nodeId() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: replyOn
    //   Field type: short, unsigned
    //   Offset (bits): 32
    //   Size (bits): 8
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'replyOn' is signed (false).
     */
    public static boolean isSigned_replyOn() {
        return false;
    }

    /**
     * Return whether the field 'replyOn' is an array (false).
     */
    public static boolean isArray_replyOn() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'replyOn'
     */
    public static int offset_replyOn() {
        return (32 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'replyOn'
     */
    public static int offsetBits_replyOn() {
        return 32;
    }

    /**
     * Return the value (as a short) of the field 'replyOn'
     */
    public short get_replyOn() {
        return (short)getUIntBEElement(offsetBits_replyOn(), 8);
    }

    /**
     * Set the value of the field 'replyOn'
     */
    public void set_replyOn(short value) {
        setUIntBEElement(offsetBits_replyOn(), 8, value);
    }

    /**
     * Return the size, in bytes, of the field 'replyOn'
     */
    public static int size_replyOn() {
        return (8 / 8);
    }

    /**
     * Return the size, in bits, of the field 'replyOn'
     */
    public static int sizeBits_replyOn() {
        return 8;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: platformId
    //   Field type: short, unsigned
    //   Offset (bits): 40
    //   Size (bits): 8
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'platformId' is signed (false).
     */
    public static boolean isSigned_platformId() {
        return false;
    }

    /**
     * Return whether the field 'platformId' is an array (false).
     */
    public static boolean isArray_platformId() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'platformId'
     */
    public static int offset_platformId() {
        return (40 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'platformId'
     */
    public static int offsetBits_platformId() {
        return 40;
    }

    /**
     * Return the value (as a short) of the field 'platformId'
     */
    public short get_platformId() {
        return (short)getUIntBEElement(offsetBits_platformId(), 8);
    }

    /**
     * Set the value of the field 'platformId'
     */
    public void set_platformId(short value) {
        setUIntBEElement(offsetBits_platformId(), 8, value);
    }

    /**
     * Return the size, in bytes, of the field 'platformId'
     */
    public static int size_platformId() {
        return (8 / 8);
    }

    /**
     * Return the size, in bits, of the field 'platformId'
     */
    public static int sizeBits_platformId() {
        return 8;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: identifyAfterBoot
    //   Field type: short, unsigned
    //   Offset (bits): 48
    //   Size (bits): 8
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'identifyAfterBoot' is signed (false).
     */
    public static boolean isSigned_identifyAfterBoot() {
        return false;
    }

    /**
     * Return whether the field 'identifyAfterBoot' is an array (false).
     */
    public static boolean isArray_identifyAfterBoot() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'identifyAfterBoot'
     */
    public static int offset_identifyAfterBoot() {
        return (48 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'identifyAfterBoot'
     */
    public static int offsetBits_identifyAfterBoot() {
        return 48;
    }

    /**
     * Return the value (as a short) of the field 'identifyAfterBoot'
     */
    public short get_identifyAfterBoot() {
        return (short)getUIntBEElement(offsetBits_identifyAfterBoot(), 8);
    }

    /**
     * Set the value of the field 'identifyAfterBoot'
     */
    public void set_identifyAfterBoot(short value) {
        setUIntBEElement(offsetBits_identifyAfterBoot(), 8, value);
    }

    /**
     * Return the size, in bytes, of the field 'identifyAfterBoot'
     */
    public static int size_identifyAfterBoot() {
        return (8 / 8);
    }

    /**
     * Return the size, in bits, of the field 'identifyAfterBoot'
     */
    public static int sizeBits_identifyAfterBoot() {
        return 8;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: radioQueueLen
    //   Field type: short, unsigned
    //   Offset (bits): 56
    //   Size (bits): 8
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'radioQueueLen' is signed (false).
     */
    public static boolean isSigned_radioQueueLen() {
        return false;
    }

    /**
     * Return whether the field 'radioQueueLen' is an array (false).
     */
    public static boolean isArray_radioQueueLen() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'radioQueueLen'
     */
    public static int offset_radioQueueLen() {
        return (56 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'radioQueueLen'
     */
    public static int offsetBits_radioQueueLen() {
        return 56;
    }

    /**
     * Return the value (as a short) of the field 'radioQueueLen'
     */
    public short get_radioQueueLen() {
        return (short)getUIntBEElement(offsetBits_radioQueueLen(), 8);
    }

    /**
     * Set the value of the field 'radioQueueLen'
     */
    public void set_radioQueueLen(short value) {
        setUIntBEElement(offsetBits_radioQueueLen(), 8, value);
    }

    /**
     * Return the size, in bytes, of the field 'radioQueueLen'
     */
    public static int size_radioQueueLen() {
        return (8 / 8);
    }

    /**
     * Return the size, in bits, of the field 'radioQueueLen'
     */
    public static int sizeBits_radioQueueLen() {
        return 8;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: serialQueueLen
    //   Field type: short, unsigned
    //   Offset (bits): 64
    //   Size (bits): 8
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'serialQueueLen' is signed (false).
     */
    public static boolean isSigned_serialQueueLen() {
        return false;
    }

    /**
     * Return whether the field 'serialQueueLen' is an array (false).
     */
    public static boolean isArray_serialQueueLen() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'serialQueueLen'
     */
    public static int offset_serialQueueLen() {
        return (64 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'serialQueueLen'
     */
    public static int offsetBits_serialQueueLen() {
        return 64;
    }

    /**
     * Return the value (as a short) of the field 'serialQueueLen'
     */
    public short get_serialQueueLen() {
        return (short)getUIntBEElement(offsetBits_serialQueueLen(), 8);
    }

    /**
     * Set the value of the field 'serialQueueLen'
     */
    public void set_serialQueueLen(short value) {
        setUIntBEElement(offsetBits_serialQueueLen(), 8, value);
    }

    /**
     * Return the size, in bytes, of the field 'serialQueueLen'
     */
    public static int size_serialQueueLen() {
        return (8 / 8);
    }

    /**
     * Return the size, in bits, of the field 'serialQueueLen'
     */
    public static int sizeBits_serialQueueLen() {
        return 8;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: rssiQueueLen
    //   Field type: short, unsigned
    //   Offset (bits): 72
    //   Size (bits): 8
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'rssiQueueLen' is signed (false).
     */
    public static boolean isSigned_rssiQueueLen() {
        return false;
    }

    /**
     * Return whether the field 'rssiQueueLen' is an array (false).
     */
    public static boolean isArray_rssiQueueLen() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'rssiQueueLen'
     */
    public static int offset_rssiQueueLen() {
        return (72 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'rssiQueueLen'
     */
    public static int offsetBits_rssiQueueLen() {
        return 72;
    }

    /**
     * Return the value (as a short) of the field 'rssiQueueLen'
     */
    public short get_rssiQueueLen() {
        return (short)getUIntBEElement(offsetBits_rssiQueueLen(), 8);
    }

    /**
     * Set the value of the field 'rssiQueueLen'
     */
    public void set_rssiQueueLen(short value) {
        setUIntBEElement(offsetBits_rssiQueueLen(), 8, value);
    }

    /**
     * Return the size, in bytes, of the field 'rssiQueueLen'
     */
    public static int size_rssiQueueLen() {
        return (8 / 8);
    }

    /**
     * Return the size, in bits, of the field 'rssiQueueLen'
     */
    public static int sizeBits_rssiQueueLen() {
        return 8;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: failCount
    //   Field type: short, unsigned
    //   Offset (bits): 80
    //   Size (bits): 8
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'failCount' is signed (false).
     */
    public static boolean isSigned_failCount() {
        return false;
    }

    /**
     * Return whether the field 'failCount' is an array (false).
     */
    public static boolean isArray_failCount() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'failCount'
     */
    public static int offset_failCount() {
        return (80 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'failCount'
     */
    public static int offsetBits_failCount() {
        return 80;
    }

    /**
     * Return the value (as a short) of the field 'failCount'
     */
    public short get_failCount() {
        return (short)getUIntBEElement(offsetBits_failCount(), 8);
    }

    /**
     * Set the value of the field 'failCount'
     */
    public void set_failCount(short value) {
        setUIntBEElement(offsetBits_failCount(), 8, value);
    }

    /**
     * Return the size, in bytes, of the field 'failCount'
     */
    public static int size_failCount() {
        return (8 / 8);
    }

    /**
     * Return the size, in bits, of the field 'failCount'
     */
    public static int sizeBits_failCount() {
        return 8;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: command_data_next
    //   Field type: int[], unsigned
    //   Offset (bits): 88
    //   Size of each element (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'command_data_next' is signed (false).
     */
    public static boolean isSigned_command_data_next() {
        return false;
    }

    /**
     * Return whether the field 'command_data_next' is an array (true).
     */
    public static boolean isArray_command_data_next() {
        return true;
    }

    /**
     * Return the offset (in bytes) of the field 'command_data_next'
     */
    public static int offset_command_data_next(int index1) {
        int offset = 88;
        if (index1 < 0 || index1 >= 4) throw new ArrayIndexOutOfBoundsException();
        offset += 0 + index1 * 16;
        return (offset / 8);
    }

    /**
     * Return the offset (in bits) of the field 'command_data_next'
     */
    public static int offsetBits_command_data_next(int index1) {
        int offset = 88;
        if (index1 < 0 || index1 >= 4) throw new ArrayIndexOutOfBoundsException();
        offset += 0 + index1 * 16;
        return offset;
    }

    /**
     * Return the entire array 'command_data_next' as a int[]
     */
    public int[] get_command_data_next() {
        int[] tmp = new int[4];
        for (int index0 = 0; index0 < numElements_command_data_next(0); index0++) {
            tmp[index0] = getElement_command_data_next(index0);
        }
        return tmp;
    }

    /**
     * Set the contents of the array 'command_data_next' from the given int[]
     */
    public void set_command_data_next(int[] value) {
        for (int index0 = 0; index0 < value.length; index0++) {
            setElement_command_data_next(index0, value[index0]);
        }
    }

    /**
     * Return an element (as a int) of the array 'command_data_next'
     */
    public int getElement_command_data_next(int index1) {
        return (int)getUIntBEElement(offsetBits_command_data_next(index1), 16);
    }

    /**
     * Set an element of the array 'command_data_next'
     */
    public void setElement_command_data_next(int index1, int value) {
        setUIntBEElement(offsetBits_command_data_next(index1), 16, value);
    }

    /**
     * Return the total size, in bytes, of the array 'command_data_next'
     */
    public static int totalSize_command_data_next() {
        return (64 / 8);
    }

    /**
     * Return the total size, in bits, of the array 'command_data_next'
     */
    public static int totalSizeBits_command_data_next() {
        return 64;
    }

    /**
     * Return the size, in bytes, of each element of the array 'command_data_next'
     */
    public static int elementSize_command_data_next() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of each element of the array 'command_data_next'
     */
    public static int elementSizeBits_command_data_next() {
        return 16;
    }

    /**
     * Return the number of dimensions in the array 'command_data_next'
     */
    public static int numDimensions_command_data_next() {
        return 1;
    }

    /**
     * Return the number of elements in the array 'command_data_next'
     */
    public static int numElements_command_data_next() {
        return 4;
    }

    /**
     * Return the number of elements in the array 'command_data_next'
     * for the given dimension.
     */
    public static int numElements_command_data_next(int dimension) {
      int array_dims[] = { 4,  };
        if (dimension < 0 || dimension >= 1) throw new ArrayIndexOutOfBoundsException();
        if (array_dims[dimension] == 0) throw new IllegalArgumentException("Array dimension "+dimension+" has unknown size");
        return array_dims[dimension];
    }

}
