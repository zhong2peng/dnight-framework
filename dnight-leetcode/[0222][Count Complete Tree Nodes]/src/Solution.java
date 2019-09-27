/**
 * @author ZHONGPENG769
 * @date 2019/9/27
 */
public class Solution {

    /**
     * Given a complete binary tree, count the number of nodes.
     * <p>
     * Note:
     * <p>
     * Definition of a complete binary tree from Wikipedia:
     * In a complete binary tree every level, except possibly the last, is completely filled,
     * and all nodes in the last level are as far left as possible.
     * It can have between 1 and 2h nodes inclusive at the last level h.
     * <p>
     * Example:
     * <p>
     * Input:
     * 1
     * / \
     * 2   3
     * / \  /
     * 4  5 6
     * <p>
     * 对于一颗二叉树，假设其深度为d（d>1）。除了第d层外，其它各层的节点数目均已达最大值，
     * 且第d层所有节点从左向右连续地紧密排列，这样的二叉树被称为完全二叉树；
     * <p>
     * 换句话说，完全二叉树从根结点到倒数第二层满足完美二叉树，最后一层可以不完全填充，其叶子结点都靠左对齐。
     * <p>
     * Output: 6
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        int h = height(root);
        return h < 0 ? 0 :
                height(root.right) == h - 1 ? (1 << h) + countNodes(root.right)
                        : (1 << h - 1) + countNodes(root.left);
    }

    private int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
}
