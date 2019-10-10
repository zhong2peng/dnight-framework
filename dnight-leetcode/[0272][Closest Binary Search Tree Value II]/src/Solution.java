import java.util.ArrayList;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/10/10
 */
public class Solution {

    /**
     * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
     * <p>
     * Note:
     * <p>
     * Given target value is a floating point.
     * You may assume k is always valid, that is: k ≤ total nodes.
     * You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
     * Follow up:
     * Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
     * <p>
     * Hint:
     * <p>
     * 1. Consider implement these two helper functions:
     * 　　i. getPredecessor(N), which returns the next smaller node to N.
     * 　　ii. getSuccessor(N), which returns the next larger node to N.
     * 2. Try to assume that each node has a parent pointer, it makes the problem much easier.
     * 3. Without parent pointer we just need to keep track of the path from the root to the current node using a stack.
     * 4. You would need two stacks to track the path in finding predecessor and successor node separately.
     * <p>
     * 270题只要找出离目标值最近的一个节点值，而这道题要找出离目标值最近的k个节点值。
     *
     * @param root
     * @param target
     * @param k
     * @return
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        inOrderTraversal(root, target, k, res);
        return res;
    }

    private void inOrderTraversal(TreeNode root, double target, int k, List<Integer> res) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, target, k, res);
        if (res.size() < k) {
            res.add(root.val);
        } else if (res.size() == k) {
            if (Math.abs(res.get(0) - target) > Math.abs(root.val - target)) {
                res.remove(0);
                res.add(root.val);
            } else {
                return;
            }
        }
        inOrderTraversal(root.right, target, k, res);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list.get(0));
        System.out.println(list.remove(0));
        System.out.println(list.get(0));
        System.out.println(list.remove(0));
        System.out.println(list.get(0));
        System.out.println(list.remove(0));
    }
}
