/**
 * @author ZHONGPENG769
 * @date 2019/8/13
 */
public class Solution {

    /**
     * Given two binary trees, write a function to check if they are the same or not.
     * Two binary trees are considered the same if they are structurally identical and
     * the nodes have the same value.
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return inorderTraversal(p, q);
    }

    private boolean inorderTraversal(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        if (!inorderTraversal(p.left, q.left)) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return inorderTraversal(p.right, q.right);
    }
}
