package pojo;

/**
 * @author ZHONGPENG769
 * @date 2019/7/4
 */
public class OrderFactory {

    public static Order create(long orderId) {
        Order order = new Order();
        order.setOrderNumber(orderId);
        order.setTotal(9999.999f);
        Address address = new Address();
        address.setCity("深圳市");
        address.setCountry("中国");
        address.setPostCode("123456");
        address.setState("广东省");
        address.setStreet1("北京路");
        order.setBillTo(address);
        Customer customer = new Customer();
        customer.setCustomerNumber(orderId);
        customer.setFirstName("dnight");
        customer.setLastName("zp");
        order.setCustomer(customer);
        order.setShipping(Shipping.INTERNATIONAL_MAIL);
        order.setShipTo(address);
        return order;
    }

}
