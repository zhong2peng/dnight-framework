package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ZHONGPENG769
 * @date 2019/7/11
 */
public class Collect1 {

    public static void main(String[] args) {
        List<String> G7 = Arrays.asList("USA", "Japan", "France");
        String G7Countries = G7.stream().map(x -> x.toUpperCase())
                .collect(Collectors.joining(", "));
        System.out.println(G7Countries);
    }
}
