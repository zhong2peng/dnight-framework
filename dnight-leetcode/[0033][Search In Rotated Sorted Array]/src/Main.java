/**
 * @author ZHONGPENG769
 * @date 2019/6/28
 */
public class Main {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.search(nums, 3));
        System.out.println(solution1.search(nums, 0));

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.search(nums, -1));
        System.out.println(solution2.search(nums, 1));
    }
}
