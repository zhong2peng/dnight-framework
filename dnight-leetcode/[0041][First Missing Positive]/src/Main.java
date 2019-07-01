/**
 * @author ZHONGPENG769
 * @date 2019/7/1
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2, 0};
        System.out.println(solution.firstMissingPositive(nums));
        int[] nums1 = new int[]{3, 4, -1, 1};
        System.out.println(solution.firstMissingPositive(nums1));
        int[] nums2 = new int[]{7, 8, 9, 11, 12};
        System.out.println(solution.firstMissingPositive(nums2));
    }
}
