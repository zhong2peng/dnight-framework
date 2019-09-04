import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/8/29
 */
public class Solution {

    /**
     * Given a binary tree, return the level order traversal of its nodes' values.
     * (ie, from left to right, level by level).
     * <p>
     * For example:
     * Given binary tree [3,9,20,null,null,15,7],
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * <p>
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 当前层
        Deque<TreeNode> cur = new LinkedList<>();
        // 下一层
        Deque<TreeNode> sub = new LinkedList<>();
        Deque<TreeNode> exc;

        TreeNode node;
        cur.addLast(root);

        while (!cur.isEmpty()) {
            List<Integer> layout = new LinkedList<>();
            while (!cur.isEmpty()) {
                node = cur.removeFirst();
                layout.add(node.val);
                if (node.left != null) {
                    sub.addLast(node.left);
                }
                if (node.right != null) {
                    sub.addLast(node.right);
                }
            }

            exc = cur;
            cur = sub;
            sub = exc;

            result.add(layout);
        }
        return result;
    }
}
