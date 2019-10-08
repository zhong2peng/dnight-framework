/**
 * @author ZHONGPENG769
 * @date 2019/10/8
 */
public class Solution {

    /**
     * Given a binary tree, count the number of uni-value subtrees.
     * <p>
     * A Uni-value subtree means all nodes of the subtree have the same value.
     * <p>
     * For example:
     * Given binary tree,
     * <p>
     * 5
     * / \
     * 1   5
     * / \   \
     * 5   5   5
     * return 4.
     * <p>
     * 给一个二叉树，求唯一值子树的个数。唯一值子树的所有节点具有相同值。
     *
     * @param root
     * @return
     */
    public int countUnivalSubtrees(TreeNode root) {
        int[] res = {0};
        dfs(root, res);
        return res[0];
    }

    private boolean dfs(TreeNode root, int[] res) {
        if (root == null) {
            return true;
        }

        boolean left = dfs(root.left, res);
        boolean right = dfs(root.right, res);
        if (left && right) {
            if (root.left != null && root.left.val != root.val) {
                return false;
            }

            if (root.right != null && root.right.val != root.val) {
                return false;
            }

            res[0]++;
            return true;
        }

        return false;
    }
}
