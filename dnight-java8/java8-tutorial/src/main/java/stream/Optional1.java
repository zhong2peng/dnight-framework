package stream;

import java.util.Optional;

/**
 * @author ZHONGPENG769
 * @date 2019/7/11
 */
public class Optional1 {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("bam");
        optional.isPresent();
        optional.get();
        optional.orElse("fallback");

        optional.ifPresent(s -> System.out.println(s.charAt(0)));
    }
}
