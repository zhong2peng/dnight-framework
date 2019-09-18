import java.util.Stack;

/**
 * @author ZHONGPENG769
 * @date 2019/9/18
 */
public class BSTIterator {
    /**
     * Implement an iterator over a binary search tree (BST).
     * Your iterator will be initialized with the root node of a BST.
     * <p>
     * Calling next() will return the next smallest number in the BST.
     * next() and hasNext() should run in average O(1) time and uses O(h) memory,
     * where h is the height of the tree.
     * <p>
     * You may assume that next() call will always be valid, that is,
     * there will be at least a next smallest number
     * in the BST when next() is called.
     */

    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode tmpNode = stack.pop();
        pushAll(tmpNode.right);
        return tmpNode.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAll(TreeNode node) {
        for (; node != null; stack.push(node), node = node.left) ;
    }
}
