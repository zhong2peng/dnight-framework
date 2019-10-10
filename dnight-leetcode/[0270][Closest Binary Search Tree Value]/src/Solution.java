/**
 * @author ZHONGPENG769
 * @date 2019/10/10
 */
public class Solution {

    /**
     * Given a non-empty binary search tree and a target value,
     * find the value in the BST that is closest to the target.
     * <p>
     * Note:
     * <p>
     * Given target value is a floating point.
     * You are guaranteed to have only one unique value in the BST that is closest to the target.
     *
     * @param root
     * @param target
     * @return
     */
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return 0;
        }
        int min = root.val;
        while (root != null) {
            min = Math.abs(target - root.val) < Math.abs(target - min) ? root.val : min;
            root = root.val < target ? root.right : root.left;
        }
        return min;
    }

    public int closestValue1(TreeNode root, double target) {
        TreeNode child = target < root.val ? root.left : root.right;
        if (child == null) {
            return root.val;
        }
        int childCloset = closestValue1(child, target);
        return Math.abs(root.val - target) < Math.abs(childCloset - target) ? root.val : childCloset;
    }
}
