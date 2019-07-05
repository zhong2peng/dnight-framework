package constant;

/**
 * @author ZHONGPENG769
 * @date 2019/7/5
 */
public enum MessageType {

    SERVICE_REQ((byte) 0),
    SERVICE_RESP((byte) 1),
    ONE_WAY((byte) 2),
    LOGIN_REQ((byte) 3),
    LOGIN_RESP((byte) 4),
    HEARTBEAT_REQ((byte) 5),
    HEATBEAT_RESP((byte) 6);

    private byte value;

    MessageType(byte value) {
        this.value = value;
    }

    public byte value() {
        return this.value;
    }
}
