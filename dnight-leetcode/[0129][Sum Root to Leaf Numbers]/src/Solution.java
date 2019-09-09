/**
 * @author ZHONGPENG769
 * @date 2019/9/9
 */
public class Solution {

    /**
     * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
     * <p>
     * An example is the root-to-leaf path 1->2->3 which represents the number 123.
     * <p>
     * Find the total sum of all root-to-leaf numbers.
     * <p>
     * Note: A leaf is a node with no children.
     * <p>
     * Example:
     * <p>
     * Input: [1,2,3]
     * 1
     * / \
     * 2   3
     * Output: 25
     * Explanation:
     * The root-to-leaf path 1->2 represents the number 12.
     * The root-to-leaf path 1->3 represents the number 13.
     * Therefore, sum = 12 + 13 = 25.
     * Example 2:
     * <p>
     * Input: [4,9,0,5,1]
     * 4
     * / \
     * 9   0
     * / \
     * 5   1
     * Output: 1026
     * Explanation:
     * The root-to-leaf path 4->9->5 represents the number 495.
     * The root-to-leaf path 4->9->1 represents the number 491.
     * The root-to-leaf path 4->0 represents the number 40.
     * Therefore, sum = 495 + 491 + 40 = 1026.
     * <p>
     * 回溯法
     *
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        sum(root);
        return result;
    }

    private void sum(TreeNode root) {
        if (root != null) {
            num = num * 10 + root.val;
            if (root.left == null && root.right == null) {
                result += num;
            }
            sum(root.left);
            sum(root.right);
            num /= 10;
        }
    }

    int result = 0;
    int num = 0;
}
