import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/7/15
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> combine = solution.combine1(4, 2);
        combine.stream().forEach(e1 -> {
            e1.stream().forEach(s -> System.out.print(s + ","));
            System.out.println();
        });
    }
}
