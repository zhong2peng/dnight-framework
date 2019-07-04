import lombok.Data;

import java.io.Serializable;

/**
 * @author ZHONGPENG769
 * @date 2019/7/4
 */
@Data
public class SubscribeResp implements Serializable {


    private static final long serialVersionUID = 1L;

    private int subReqId;
    private int respCode;
    private String desc;
}
