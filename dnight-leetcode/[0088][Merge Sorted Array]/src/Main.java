/**
 * Author: dnight
 * Date: 2019/8/5 23:25
 */
public class Main {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3, n = 3;
        int[] nums2 = {2, 5, 6};
        Solution solution = new Solution();
        solution.merge(nums1, m, nums2, n);
        for (int value : nums1) {
            System.out.print(value + ", ");
        }
    }
}
