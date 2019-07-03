import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.msgpack.annotation.Message;

/**
 * @author ZHONGPENG769
 * @date 2019/7/3
 */
@Message
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageInfo {
    private int id;
    private String name;
    private double version;

}
