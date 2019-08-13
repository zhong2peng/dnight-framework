/**
 * @author ZHONGPENG769
 * @date 2019/8/13
 */
public class Solution {

    /**
     * Two elements of a binary search tree (BST) are swapped by mistake.
     * <p>
     * Recover the tree without changing its structure.
     * 一个合法的二分查找树随机交换了两个数的位置，然后让我们恢复二分查找树。不能改变原来的结构，只是改变两个数的位置。
     *
     * @param root
     */
    public void recoverTree(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;
        TreeNode cur = root;
        TreeNode pre_new = null;

        while (cur != null) {
            if (cur.left == null) {
                if (pre_new != null && cur.val < pre_new.val) {
                    if (first == null) {
                        first = pre_new;
                        second = cur;
                    } else {
                        second = cur;
                    }
                }
                pre_new = cur;
                cur = cur.right;
            } else {
                TreeNode pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                }
                if (pre.right == cur) {
                    pre.right = null;
                    if (pre_new != null && cur.val < pre_new.val) {
                        if (first == null) {
                            first = pre_new;
                            second = cur;
                        } else {
                            second = cur;
                        }
                    }
                    pre_new = cur;
                    cur = cur.right;
                }
            }
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
