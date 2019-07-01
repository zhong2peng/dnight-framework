import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/7/1
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        print(solution.combinationSum(candidates, target));

        int[] candidates1 = new int[]{2, 3, 5};
        target = 8;
        print(solution.combinationSum(candidates1, target));
    }

    public static void print(List<List<Integer>> lists) {
        for (List<Integer> tmp : lists) {
            for (Integer i : tmp) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }
    }
}
