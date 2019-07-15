import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/7/15
 */
public class Main {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> subsets1 = solution.subsets(nums);
        Solution1 solution1 = new Solution1();
        List<List<Integer>> subsets2 = solution1.subsets(nums);
        Solution2 solution2 = new Solution2();
        List<List<Integer>> subsets3 = solution2.subsets(nums);

        print(subsets1);
        System.out.println("==============");
        print(subsets2);
        System.out.println("==============");
        print(subsets3);
    }

    public static void print(List<List<Integer>> result) {
        result.stream().forEach(
                s -> {
                    s.stream().forEach(
                            e1 -> System.out.print(e1 + ", ")
                    );
                    System.out.println();
                }
        );
    }
}
