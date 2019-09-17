/**
 * @author ZHONGPENG769
 * @date 2019/9/17
 */
public class Solution {

    /**
     * Given a binary tree where all the right nodes are either leaf nodes with a sibling
     * (a left node that shares the same parent node) or empty,
     * flip it upside down and turn it into a tree where the original right nodes
     * turned into left leaf nodes. Return the new root.
     * <p>
     * For example:
     * <p>
     * Given a binary tree {1,2,3,4,5},
     * <p>
     * 1
     * / \
     * 2   3
     * / \
     * 4 5
     * <p>
     * return the root of the binary tree [4,5,2,#,#,3,1].
     * 4
     * /  \
     * 5   2
     * /  \
     * 3  1
     * <p>
     * 给一个二叉树，右节点要么为空要么一定会有对应的左节点，把二叉树上下颠倒一下，原二叉树的最左子节点变成了根节点，其对应的右节点变成了其左子节点，其父节点变成了其右子节点。
     * 递归
     *
     * @param root
     * @return
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        // 左转置
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public TreeNode upsideDownBinaryTree1(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        TreeNode tmp = null;
        TreeNode next = null;
        while (cur != null) {
            next = cur.left;
            // need tmp to keep the previous right child
            cur.left = tmp;
            tmp = cur.right;

            cur.right = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
