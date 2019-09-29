/**
 * @author ZHONGPENG769
 * @date 2019/9/29
 */
public class Solution {

    /**
     * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
     * <p>
     * Note:
     * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
     * <p>
     * Example 1:
     * <p>
     * Input: root = [3,1,4,null,2], k = 1
     * 3
     * / \
     * 1   4
     * \
     * 2
     * Output: 1
     * Example 2:
     * <p>
     * Input: root = [5,3,6,2,4,null,null,1], k = 3
     * 5
     * / \
     * 3   6
     * / \
     * 2   4
     * /
     * 1
     * Output: 3
     * Follow up:
     * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
     * How would you optimize the kthSmallest routine?
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k - 1 - count);
        }
        return root.val;
    }

    private int countNodes(TreeNode n) {
        if (n == null) {
            return 0;
        }
        return 1 + countNodes(n.left) + countNodes(n.right);
    }

    // DFS
    private static int number = 0;
    private static int count = 0;

    public int kthSmallest1(TreeNode root, int k) {
        count = k;
        helper(root);
        return number;
    }

    private void helper(TreeNode node) {
        if (node.left != null) {
            helper(node.left);
        }
        count--;
        if (count == 0) {
            number = node.val;
            return;
        }
        if (node.right != null) {
            helper(node.right);
        }
    }
}
