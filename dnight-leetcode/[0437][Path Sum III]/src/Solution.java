import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ZHONGPENG769
 * @date 2019/10/29
 */
public class Solution {

    /**
     * You are given a binary tree in which each node contains an integer value.
     * <p>
     * Find the number of paths that sum to a given value.
     * <p>
     * The path does not need to start or end at the root or a leaf,
     * but it must go downwards (traveling only from parent nodes to child nodes).
     * <p>
     * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
     * <p>
     * Example:
     * <p>
     * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
     * <p>
     * 10
     * /  \
     * 5   -3
     * / \    \
     * 3   2   11
     * / \   \
     * 3  -2   1
     * <p>
     * Return 3. The paths that sum to 8 are:
     * <p>
     * 1.  5 -> 3
     * 2.  5 -> 2 -> 1
     * 3. -3 -> 11
     *
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        int res = 0;
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int[] tmp = new int[1];
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            tmp[0] = 0;
            calculate(poll, sum, tmp);
            res += tmp[0];
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
        return res;
    }

    private void calculate(TreeNode node, int remain, int[] res) {
        if (node == null) {
            return;
        }
        if (node.val == remain) {
            res[0] += 1;
        }
        calculate(node.left, remain - node.val, res);
        calculate(node.right, remain - node.val, res);
    }


    public int pathSum1(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return pathSumFrom(root, sum) + pathSum1(root.left, sum) + pathSum1(root.right, sum);
    }

    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        return (node.val == sum ? 1 : 0)
                + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    }
}
