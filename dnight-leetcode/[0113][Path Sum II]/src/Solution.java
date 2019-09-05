import java.util.LinkedList;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/9/4
 */
public class Solution {

    /**
     * Given a binary tree and a sum, find all root-to-leaf paths
     * where each path's sum equals the given sum.
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
     * /  \    / \
     * 7    2  5   1
     * Return:
     * <p>
     * [
     * [5,4,11,2],
     * [5,8,4,5]
     * ]
     *
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new LinkedList<>();
        this.sum = sum;
        l = new LinkedList<>();
        calculate(root);
        return result;
    }

    private List<List<Integer>> result;
    private List<Integer> l;
    private int sum;
    private int curSum = 0;

    private void calculate(TreeNode node) {
        if (node != null) {
            l.add(node.val);
            curSum += node.val;
            if (node.left == null && node.right == null && (curSum == sum)) {
                List<Integer> list = new LinkedList<>();
                for (Integer i : l) {
                    list.add(i);
                }
                result.add(list);
            }
            if (node.left != null) {
                calculate(node.left);
            }
            if (node.right != null) {
                calculate(node.right);
            }
            curSum -= node.val;
            l.remove(l.size() - 1);
        }
    }
}
