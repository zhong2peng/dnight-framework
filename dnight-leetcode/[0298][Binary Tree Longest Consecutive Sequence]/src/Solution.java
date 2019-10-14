/**
 * @author ZHONGPENG769
 * @date 2019/10/14
 */
public class Solution {

    private int maxLen = 0;

    /**
     * Given a binary tree, find the length of the longest consecutive sequence path.
     * <p>
     * The path refers to any sequence of nodes from some starting node to any node in the tree
     * along the parent-child connections. The longest consecutive path need to be from parent to
     * child (cannot be the reverse).
     * <p>
     * For example,
     * <p>
     * 1
     * \
     * 3
     * / \
     * 2   4
     * \
     * 5
     * Longest consecutive sequence path is 3-4-5, so return 3.
     * <p>
     * 2
     * \
     * 3
     * /
     * 2
     * /
     * 1
     * <p>
     * 给一个二叉树，求其中最长连续序列的长度
     *
     * @param root
     * @return
     */
    public int longestConsecutive(TreeNode root) {
        longestConsecutive(root, 0, 0);
        return maxLen;
    }

    private void longestConsecutive(TreeNode root, int lastVal, int curLen) {
        if (root == null) {
            return;
        }
        if (root.val != lastVal + 1) {
            curLen = 1;
        } else {
            curLen++;
        }
        maxLen = Math.max(maxLen, curLen);
        longestConsecutive(root.left, root.val, curLen);
        longestConsecutive(root.right, root.val, curLen);
    }
}
