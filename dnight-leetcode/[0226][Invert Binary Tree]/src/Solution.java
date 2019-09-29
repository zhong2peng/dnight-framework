/**
 * @author ZHONGPENG769
 * @date 2019/9/29
 */
public class Solution {

    /**
     * Invert a binary tree.
     * <p>
     * Example:
     * <p>
     * Input:
     * <p>
     * 4
     * /   \
     * 2     7
     * / \   / \
     * 1   3 6   9
     * Output:
     * <p>
     * 4
     * /   \
     * 7     2
     * / \   / \
     * 9   6 3   1
     * Trivia:
     * This problem was inspired by this original tweet by Max Howell:
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root != null && (root.left != null || root.right != null)) {
            TreeNode left = root.left;
            root.left = root.right;
            root.right = left;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }


}
