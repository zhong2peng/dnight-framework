package pojo;

import lombok.Data;

/**
 * @author ZHONGPENG769
 * @date 2019/7/4
 */
@Data
public class Order {
    private long orderNumber;
    private Customer customer;
    private Address billTo;
    private Shipping shipping;
    private Address shipTo;
    private Float total;
}
