package lambda;

import java.util.HashMap;
import java.util.function.BiConsumer;

/**
 * @author ZHONGPENG769
 * @date 2019/7/10
 */
public class Lambda5 {

    public static void main(String[] args) {
        //消费
        BiConsumer<String, Integer> printKeyAndValue =
                (key, value) -> System.out.println(key + "-" + value);
        printKeyAndValue.accept("One", 1);
        printKeyAndValue.accept("Two", 2);
        System.out.println("################");
        HashMap<String, Integer> dummyValues = new HashMap<>();
        dummyValues.put("One", 1);
        dummyValues.put("Two", 2);
        dummyValues.put("Three", 3);
        dummyValues.forEach((key, val) -> System.out.println(key + "->" + val));
    }
}
