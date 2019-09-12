import java.util.*;

/**
 * @author ZHONGPENG769
 * @date 2019/9/12
 */
public class Solution {

    /**
     * Given a binary tree, return the postorder traversal of its nodes' values.
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
     * Output: [3,2,1]
     * Follow up: Recursive solution is trivial, could you do it iteratively?
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root, result);
        return result;
    }

    private void postorderTraversal(TreeNode root, List<Integer> result) {
        if (root != null) {
            if (root.left != null) {
                postorderTraversal(root.left, result);
            }
            if (root.right != null) {
                postorderTraversal(root.right, result);
            }
            result.add(root.val);
        }
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode node = root;
        // 根，右，左，逆序加入，即可获得后序遍历的链表
        while (!nodeStack.isEmpty() || node != null) {
            if (node != null) {
                result.add(0, node.val);
                if (node.left != null) {
                    // 左压栈，不断遍历右子树，对应的左子树随着深度不断的压栈
                    nodeStack.push(node.left);
                }
                node = node.right;
            } else {
                node = nodeStack.pop();
            }
        }
        return result;
    }


}
