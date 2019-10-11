/**
 * @author ZHONGPENG769
 * @date 2019/10/11
 */
public class Solution {

    /**
     * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
     * <p>
     * Note: If the given node has no in-order successor in the tree, return null.
     * 求二叉搜索树的某个节点的中序后继节点
     *
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        TreeNode successor = null;
        while (root != null) {
            if (p.val < root.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return successor;
    }

    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        TreeNode res = null;
        inorder(root, p, res);
        return res;
    }

    private void inorder(TreeNode node, TreeNode p, TreeNode res) {
        if (node == null) {
            return;
        }
        if (node.val == p.val) {
            findTheAfter(node.right, res);
            return;
        }
        inorder(node.left, p, res);
        inorder(node.right, p, res);
    }

    private void findTheAfter(TreeNode right, TreeNode res) {
        if (right.left != null) {
            findTheAfter(right.left, res);
        } else {
            res = right;
        }
    }
}
