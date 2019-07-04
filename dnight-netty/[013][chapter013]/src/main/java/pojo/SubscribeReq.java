package pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ZHONGPENG769
 * @date 2019/7/4
 */
@Data
public class SubscribeReq implements Serializable {

    private static final long serialVersionUID = 1L;

    private int subReqId;
    private String userName;
    private String productName;
    private String phoneNumber;
    private String address;
}
