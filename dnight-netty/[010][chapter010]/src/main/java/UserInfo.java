import lombok.Data;

import java.io.Serializable;
import java.nio.ByteBuffer;

/**
 * @author ZHONGPENG769
 * @date 2019/7/3
 */
@Data
public class UserInfo implements Serializable {
    private static final Long serialVersionUID = 1L;
    private String userName;
    private int userId;

    public UserInfo buildUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public UserInfo buildUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public byte[] codeC() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        return codeC(buffer);
    }

    public byte[] codeC(ByteBuffer buffer) {
        buffer.clear();
        byte[] value = this.userName.getBytes();
        buffer.putInt(value.length);
        buffer.put(value);
        buffer.putInt(userId);
        buffer.flip();
        byte[] result = new byte[buffer.remaining()];
        buffer.get(result);
        return result;
    }
}
