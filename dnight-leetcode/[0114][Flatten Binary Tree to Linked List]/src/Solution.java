/**
 * @author ZHONGPENG769
 * @date 2019/9/4
 */
public class Solution {

    /**
     * Given a binary tree, flatten it to a linked list in-place.
     * For example, given the following tree:
     * <p>
     * 1
     * / \
     * 2   5
     * / \   \
     * 3   4   6
     * The flattened tree should look like:
     * <p>
     * 1
     * \
     * 2
     * \
     * 3
     * \
     * 4
     * \
     * 5
     * \
     * 6
     * <p>
     * 给定一棵二叉树，将它转成单链表，使用原地算法
     * 解题思路：
     * 从根结点（root）找左子树（l）的最右子结点（x），将root的右子树（r）接到x的右子树上（x的右子树为空），
     * root的左子树整体调整为右子树，root的左子树赋空。
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        TreeNode head = new TreeNode(-1);
        head.right = root;
        TreeNode node = head;
        while (node.right != null) {
            node = node.right;
            if (node.left != null) {
                TreeNode end = node.left;
                while (end.right != null) {
                    end = end.right;
                }
                TreeNode tmp = node.right;

                node.right = node.left;
                node.left = null;
                end.right = tmp;
            }
        }
        head.right = null;
    }
}
