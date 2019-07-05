package struct;

import lombok.Data;

/**
 * @author ZHONGPENG769
 * @date 2019/7/5
 */
@Data
public class NettyMessage {

    private Header header;
    private Object body;

}
