/**
 * @author ZHONGPENG769
 * @date 2019/7/2
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println(solution.canJump(nums1));
        System.out.println(solution.canJump(nums2));
        System.out.println(solution.canJump1(nums1));
        System.out.println(solution.canJump1(nums2));
    }
}
