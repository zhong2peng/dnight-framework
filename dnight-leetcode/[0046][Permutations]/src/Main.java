import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/7/1
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2, 3};
        print(solution.permute(nums));
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
