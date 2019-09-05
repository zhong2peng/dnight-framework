/**
 * @author ZHONGPENG769
 * @date 2019/9/4
 */
public class Solution {

    private boolean stop = false;

    /**
     * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
     * such that adding up all the values along the path equals the given sum.
     * <p>
     * Note: A leaf is a node with no children.
     * <p>
     * Example:
     * <p>
     * Given the below binary tree and sum = 22,
     * <p>
     * 5
     * / \
     * 4   8
     * /   / \
     * 11  13  4
     * /  \      \
     * 7    2      1
     * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
     * <p>
     * 回溯法
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        calculate(root, 0, sum);
        return stop;
    }

    /**
     * 计算根到叶子节点的和
     *
     * @param node 当前处理的节点
     * @param cur  从根节点到当前节点之前的所有节点和
     * @param sum  要求的和
     */
    private void calculate(TreeNode node, int cur, int sum) {
        if (!stop && node != null) {
            if (node.left == null && node.right == null && (node.val + cur == sum)) {
                stop = true;
            }
            if (node.left != null) {
                calculate(node.left, cur + node.val, sum);
            }

            if (node.right != null) {
                calculate(node.right, cur + node.val, sum);
            }
        }
    }
}
