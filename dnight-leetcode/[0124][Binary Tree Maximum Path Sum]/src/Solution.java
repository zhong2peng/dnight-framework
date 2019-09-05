/**
 * @author ZHONGPENG769
 * @date 2019/9/5
 */
public class Solution {

    /**
     * Given a non-empty binary tree, find the maximum path sum.
     * For this problem, a path is defined as any sequence of nodes from some starting node
     * to any node in the tree along the parent-child connections.
     * The path must contain at least one node and does not need to go through the root.
     * <p>
     * Example 1:
     * <p>
     * Input: [1,2,3]
     * <p>
     * 1
     * / \
     * 2   3
     * <p>
     * Output: 6
     * Example 2:
     * <p>
     * Input: [-10,9,20,null,null,15,7]
     * <p>
     * -10
     * / \
     * 9  20
     * /  \
     * 15   7
     * <p>
     * 计算二叉算的最大路径和，路径的起始和终点可以在任意结点
     * Output: 42
     *
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException();
        }
        max = Integer.MIN_VALUE;
        maxPathSumHelper(root);
        return max;
    }

    private int maxPathSumHelper(TreeNode root) {
        if (root != null) {
            int left = Math.max(maxPathSumHelper(root.left), 0);
            int right = Math.max(maxPathSumHelper(root.right), 0);
            max = Math.max(max, root.val + left + right);
            return root.val + Math.max(left, right);
        } else {
            return 0;
        }
    }

    private int max;
}
