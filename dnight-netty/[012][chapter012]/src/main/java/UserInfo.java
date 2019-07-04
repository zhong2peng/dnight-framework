import lombok.Data;
import org.msgpack.annotation.Message;

import java.io.Serializable;

/**
 * @author ZHONGPENG769
 * @date 2019/7/4
 */
@Message
@Data
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userName;
    private int userId;
    private int age;

    public UserInfo buildUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public UserInfo buildUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public UserInfo buildAge(int age) {
        this.age = age;
        return this;
    }
}
