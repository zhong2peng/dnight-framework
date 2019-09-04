import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/8/29
 */
public class Solution {

    /**
     * Given a binary tree, return the zigzag level order traversal of its nodes' values.
     * (ie, from left to right, then right to left for the next level and alternate between).
     * <p>
     * For example:
     * Given binary tree [3,9,20,null,null,15,7],
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * return its zigzag level order traversal as:
     * [
     * [3],
     * [20,9],
     * [15,7]
     * ]
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        //0表示从左到右，1表示从右到左
        int flag = 0;
        TreeNode node;
        //记录每一层的元素
        List<Integer> lay = new LinkedList<>();
        // 双向队列，记录当前层待处理节点
        Deque<TreeNode> stack = new LinkedList<>();
        // 记录下一层待处理节点
        Deque<TreeNode> nextStack = new LinkedList<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            node = stack.removeLast();
            lay.add(node.val);
            if (flag == 0) {
                if (node.left != null) {
                    nextStack.addLast(node.left);
                }
                if (node.right != null) {
                    nextStack.addLast(node.right);
                }
            } else {
                if (node.right != null) {
                    nextStack.addLast(node.right);
                }
                if (node.left != null) {
                    nextStack.addLast(node.left);
                }
            }

            if (stack.isEmpty()) {
                Deque<TreeNode> temp = nextStack;
                nextStack = stack;
                stack = temp;
                flag = 1 - flag;
                result.add(lay);
                lay = new LinkedList<>();
            }
        }
        return result;

    }
}
