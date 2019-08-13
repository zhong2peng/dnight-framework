/**
 * @author ZHONGPENG769
 * @date 2019/8/13
 */
public class Solution {

    /**
     * Given a binary tree, determine if it is a valid binary search tree (BST).
     * <p>
     * Assume a BST is defined as follows:
     * The left subtree of a node contains only nodes with keys less than the node's key.
     * The right subtree of a node contains only nodes with keys greater than the node's key.
     * Both the left and right subtrees must also be binary search trees.
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return getAns(root, null, null);
    }

    private boolean getAns(TreeNode node, Integer minValue, Integer maxValue) {
        if (node == null) {
            return true;
        }
        if (minValue != null && node.val <= minValue) {
            return false;
        }
        if (maxValue != null && node.val >= maxValue) {
            return false;
        }
        return getAns(node.left, minValue, node.val) && getAns(node.right, node.val, maxValue);
    }
}
