/**
 * @author ZHONGPENG769
 * @date 2019/7/1
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 3, 1, 1, 4};
        //The minimum number of jumps to reach the last index is 2.
        //Jump 1 step from index 0 to 1, then 3 steps to the last index.
        System.out.println(solution.jump(nums));
        int[] nums1 = new int[]{3, 2, 1, 1, 1, 4};
        int[] nums2 = new int[]{2, 1, 1, 3, 1, 4};
        System.out.println(solution.jump(nums1));
        System.out.println(solution.jump(nums2));
    }
}
