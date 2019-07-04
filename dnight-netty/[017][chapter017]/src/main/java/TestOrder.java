import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import pojo.Order;
import pojo.OrderFactory;

import java.io.IOException;

/**
 * @author ZHONGPENG769
 * @date 2019/7/4
 */
public class TestOrder {

    private XmlMapper xmlMapper = new XmlMapper();

    private String encode2Xml(Order order) throws JsonProcessingException {
        return xmlMapper.writeValueAsString(order);
    }

    private Order decode2Order(String xmlStr) throws IOException {
        return xmlMapper.readValue(xmlStr, Order.class);
    }

    public static void main(String[] args) throws IOException {
        TestOrder testOrder = new TestOrder();
        Order order = OrderFactory.create(123);
        String body = testOrder.encode2Xml(order);
        System.out.println(body);
        Order order2 = testOrder.decode2Order(body);
        System.out.println(order2);
    }
}
