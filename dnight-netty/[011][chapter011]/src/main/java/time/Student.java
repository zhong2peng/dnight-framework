package time;

import lombok.Data;
import org.msgpack.annotation.Message;

/**
 * @author ZHONGPENG769
 * @date 2019/7/3
 */
@Message
@Data
public class Student {
    private int id;
    private String name;
}
