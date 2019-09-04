/**
 * @author ZHONGPENG769
 * @date 2019/9/3
 */
public class Solution {

    /**
     * Given an array where elements are sorted in ascending order,
     * convert it to a height balanced BST.
     * <p>
     * For this problem, a height-balanced binary tree is defined as a binary tree
     * in which the depth of the two subtrees of every node never differ by more than 1.
     * <p>
     * Example:
     * <p>
     * Given the sorted array: [-10,-3,0,5,9],
     * <p>
     * One possible answer is: [0,-3,9,-10,null,5],
     * which represents the following height balanced BST:
     * <p>
     * 0
     * / \
     * -3   9
     * /   /
     * -10  5
     * <p>
     * 高度平衡二叉树，采用递归分治法
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length < 1) {
            return null;
        }
        return solve(nums, 0, nums.length - 1);
    }

    /**
     * 递归分治算法
     *
     * @param nums  升序排序数组
     * @param start 开始位置
     * @param end   结束为止
     * @return
     */
    private TreeNode solve(int[] nums, int start, int end) {
        if (start <= end) {
            int mid = (start + end) >> 1;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = solve(nums, start, mid - 1);
            root.right = solve(nums, mid + 1, end);
            return root;
        }
        return null;
    }
}
