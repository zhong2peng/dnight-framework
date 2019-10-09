/**
 * @author ZHONGPENG769
 * @date 2019/10/9
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {5, 2, 6, 1, 3};
        int[] nums2 = {5, 2, 1, 3, 6};
        System.out.println(solution.verifyPreorder(nums1));
        System.out.println(solution.verifyPreorder(nums2));
        System.out.println(solution.verifyPreorder1(nums1));
        System.out.println(solution.verifyPreorder1(nums2));

    }
}
