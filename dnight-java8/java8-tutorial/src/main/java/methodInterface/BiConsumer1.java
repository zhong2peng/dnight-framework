package methodInterface;

import util.Utils;

import java.util.LinkedHashSet;
import java.util.function.BiConsumer;

/**
 * @author ZHONGPENG769
 * @date 2019/7/11
 */
public class BiConsumer1 {

    public static void main(String[] args) {
        //类+动态方法
        BiConsumer<LinkedHashSet, Object> biConsumer1 = LinkedHashSet::add;
        LinkedHashSet s1 = new LinkedHashSet();
        biConsumer1.accept(s1, "aaa");
        System.out.println(s1);

        //类+静态方法
        BiConsumer<String, Long> biConsumer2 = Utils::concatStatic;
        biConsumer2.accept("first_param", 6L);

        //类实例对象+动态方法
        BiConsumer<String, Long> biConsumer3 = new Utils()::concat;
        biConsumer3.accept("last_param", 8L);
    }
}
