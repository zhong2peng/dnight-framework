/**
 * @author ZHONGPENG769
 * @date 2019/8/29
 */
public class Solution {

    /**
     * Given a binary tree, find its maximum depth.
     * The maximum depth is the number of nodes along the longest path from the root node
     * down to the farthest leaf node.
     * <p>
     * Note: A leaf is a node with no children.
     * <p>
     * Example:
     * <p>
     * Given binary tree [3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * return its depth = 3.
     * <p>
     * 递归求解，递归公式
     * f(n) = 0; n=null
     * f(n) = 1 + max(f(n左), f(n右))
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return 1 + ((left > right) ? left : right);
        }
    }
}
