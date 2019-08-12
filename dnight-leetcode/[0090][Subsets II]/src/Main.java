import java.util.List;

/**
 * Author: dnight
 * Date: 2019/8/12 22:05
 */
public class Main {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.subsetsWithDup(nums);
        for (List<Integer> temp : lists) {
            for (Integer val : temp) {
                System.out.print(val + ",");
            }
            System.out.println();
        }
        System.out.println("结束");
    }
}
