import java.util.Arrays;

/**
 * @author ZHONGPENG769
 * @date 2019/6/27
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {3, 2, 1};
        int[] nums3 = {1, 1, 5};
        int[] nums4 = {1, 3, 2};
        solution.nextPermutation(nums1);
        solution.nextPermutation(nums2);
        solution.nextPermutation(nums3);
        solution.nextPermutation(nums4);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(nums3));
        System.out.println(Arrays.toString(nums4));
    }
}
