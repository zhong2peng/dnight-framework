/**
 * @author ZHONGPENG769
 * @date 2019/9/4
 */
public class Solution {

    /**
     * Given a binary tree, determine if it is height-balanced.
     * For this problem, a height-balanced binary tree is defined as:
     * a binary tree in which the depth of the two subtrees of every node
     * never differ by more than 1.
     * <p>
     * Example 1:
     * <p>
     * Given the following tree [3,9,20,null,null,15,7]:
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * Return true.
     * <p>
     * Example 2:
     * <p>
     * Given the following tree [1,2,2,3,3,null,null,4,4]:
     * <p>
     * 1
     * / \
     * 2   2
     * / \
     * 3   3
     * / \
     * 4   4
     * Return false.
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        if (left - right > 1 || left - right < -1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    private int depth(TreeNode n) {
        if (n == null) {
            return 0;
        }
        if (n.left == null && n.right == null) {
            return 1;
        } else {
            int left = depth(n.left);
            int right = depth(n.right);
            return 1 + (left > right ? left : right);
        }
    }
}
