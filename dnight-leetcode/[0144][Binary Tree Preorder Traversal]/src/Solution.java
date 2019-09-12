import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author ZHONGPENG769
 * @date 2019/9/12
 */
public class Solution {

    /**
     * Given a binary tree, return the preorder traversal of its nodes' values.
     * <p>
     * Example:
     * <p>
     * Input: [1,null,2,3]
     * 1
     * \
     * 2
     * /
     * 3
     * <p>
     * Output: [1,2,3]
     * Follow up: Recursive solution is trivial, could you do it iteratively?
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        preorderTraversal(root, result);
        return result;
    }

    public void preorderTraversal(TreeNode node, List<Integer> result) {
        if (node != null) {
            result.add(node.val);
            preorderTraversal(node.left, result);
            preorderTraversal(node.right, result);
        }
    }

    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> nodeStoreStack = new Stack<>();
        nodeStoreStack.push(root);
        while (!nodeStoreStack.isEmpty()) {
            TreeNode current = nodeStoreStack.pop();
            result.add(current.val);
            if (current.right != null) {
                nodeStoreStack.push(current.right);
            }
            if (current.left != null) {
                nodeStoreStack.push(current.left);
            }
        }
        return result;
    }


}
