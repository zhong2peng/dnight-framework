/**
 * @author ZHONGPENG769
 * @date 2019/9/4
 */
public class Solution {

    /**
     * Given a binary tree, find its minimum depth.
     * <p>
     * The minimum depth is the number of nodes along the shortest path
     * from the root node down to the nearest leaf node.
     * <p>
     * Note: A leaf is a node with no children.
     * <p>
     * Example:
     * <p>
     * Given binary tree [3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * return its minimum depth = 2.
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        return minDepth(root, false);
    }

    private int minDepth(TreeNode root, boolean hasBrother) {
        if (root == null) {
            // 自己为null，兄弟不为null，上层有子节点，说明当前还没有找到最小层
            // 没有兄弟，说明遍历到当前时，局部最小层已经找到
            return hasBrother ? Integer.MAX_VALUE : 0;
        }
        return 1 + Math.min(minDepth(root.left, root.right != null),
                minDepth(root.right, root.left != null));

    }
}
