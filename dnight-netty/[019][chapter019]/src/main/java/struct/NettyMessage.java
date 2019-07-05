package struct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ZHONGPENG769
 * @date 2019/7/5
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NettyMessage {
    private Header header;
    private Object body;
}
