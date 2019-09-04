/**
 * @author ZHONGPENG769
 * @date 2019/9/2
 */
public class Solution {

    /**
     * Given inorder and postorder traversal of a tree, construct the binary tree.
     * <p>
     * Note:
     * You may assume that duplicates do not exist in the tree.
     * <p>
     * For example, given
     * <p>
     * inorder = [9,3,15,20,7]
     * postorder = [9,15,7,20,3]
     * Return the following binary tree:
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        return solve(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    /**
     * @param inorder   中序遍历的数组
     * @param x         中序遍历的起始点
     * @param y         中序遍历的终止点
     * @param postorder 后序遍历的数组
     * @param i         后序遍历的起始点
     * @param j         后序遍历的终止点
     * @return
     */
    private TreeNode solve(int[] inorder, int x, int y, int[] postorder, int i, int j) {
        if (x >= 0 && x <= y && i >= 0 && i <= j) {
            if (x == y) {
                return new TreeNode(postorder[j]);
            } else if (x < y) {
                int idx = x;
                while (idx < y && inorder[idx] != postorder[j]) {
                    idx++;
                }
                TreeNode root = new TreeNode(postorder[j]);
                int leftLength = idx - x;
                if (leftLength > 0) {
                    root.left = solve(inorder, x, idx - 1, postorder, i, i + leftLength - 1);
                }
                int rightLength = y - idx;
                if (rightLength > 0) {
                    root.right = solve(inorder, idx + 1, y, postorder, j - rightLength, j - 1);
                }
                return root;
            }
        }
        return null;
    }
}
