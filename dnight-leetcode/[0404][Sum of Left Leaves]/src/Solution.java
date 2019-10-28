/**
 * @author ZHONGPENG769
 * @date 2019/10/28
 */
public class Solution {

    /**
     * Find the sum of all left leaves in a given binary tree.
     * <p>
     * Example:
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * <p>
     * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        int[] res = new int[1];
        sum(root, res);
        return res[0];
    }

    private void sum(TreeNode node, int[] sum) {
        if (node == null) {
            return;
        }
        if (node.left != null && node.left.left == null && node.left.right == null) {
            sum[0] += node.left.val;
        }
        if (node.left != null) {
            sum(node.left, sum);
        }
        if (node.right != null) {
            sum(node.right, sum);
        }
    }
}
