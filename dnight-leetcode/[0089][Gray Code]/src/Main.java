import java.util.List;

/**
 * Author: dnight
 * Date: 2019/8/12 21:51
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> list = solution.grayCode(3);
        list.stream().forEach(s -> System.out.print(s + ","));
    }
}
