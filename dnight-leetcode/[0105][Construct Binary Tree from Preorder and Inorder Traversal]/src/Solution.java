/**
 * @author ZHONGPENG769
 * @date 2019/8/30
 */
public class Solution {

    /**
     * Given preorder and inorder traversal of a tree, construct the binary tree.
     * <p>
     * Note:
     * You may assume that duplicates do not exist in the tree.
     * <p>
     * For example, given
     * <p>
     * preorder = [3,9,20,15,7]
     * inorder = [9,3,15,20,7]
     * Return the following binary tree:
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * <p>
     * 思路：
     * 前序遍历第一个元素是根节点(k)，在中序遍历序列中找值为k的下标idx
     * idx将中序遍历分成左右子树，对前序遍历序列也一样，可进行递归操作
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0
                || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        return solve(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    /**
     * 构建二叉树，数据输入的正确性由输入数据自己保证
     *
     * @param preorder 先序遍历的结果
     * @param x        先序遍历开始的位置
     * @param y        先序遍历结束的位置
     * @param inorder  中序遍历的结果
     * @param i        中序遍历开始的位置
     * @param j        中序遍历结束的位置
     * @return
     */
    public TreeNode solve(int[] preorder, int x, int y, int[] inorder, int i, int j) {
        if (x >= 0 && x <= y && i >= 0 && i <= j) {
            if (x == y) {
                return new TreeNode(preorder[x]);
            } else if (x < y) {
                int idx = i;
                while (idx <= j && inorder[idx] != preorder[x]) {
                    idx++;
                }
                TreeNode root = new TreeNode(inorder[idx]);
                int leftLength = idx - i;
                if (leftLength > 0) {
                    root.left = solve(preorder, x + 1, x + leftLength, inorder, i, idx - 1);
                }
                int rightLength = j - idx;
                if (rightLength > 0) {
                    root.right = solve(preorder, x + leftLength + 1, y, inorder, idx + 1, j);
                }
                return root;
            }
        }
        return null;
    }
}
