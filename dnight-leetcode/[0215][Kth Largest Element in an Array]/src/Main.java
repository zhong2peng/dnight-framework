/**
 * @author ZHONGPENG769
 * @date 2019/9/27
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int kthLargest = solution.findKthLargest(nums, k);
        System.out.println(kthLargest);
    }
}
