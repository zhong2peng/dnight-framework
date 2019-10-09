import java.util.ArrayList;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/10/9
 */
public class Solution {

    /**
     * Given a binary tree, return all root-to-leaf paths.
     * <p>
     * Note: A leaf is a node with no children.
     * <p>
     * Example:
     * <p>
     * Input:
     * <p>
     * 1
     * /   \
     * 2     3
     * \
     * 5
     * <p>
     * Output: ["1->2->5", "1->3"]
     * <p>
     * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root != null) {
            helper(root, res, "");
        }
        return res;
    }

    private void helper(TreeNode node, List<String> res, String path) {
        if (node.left == null && node.right == null) {
            path = path + node.val;
            res.add(path);
        }
        if (node.left != null) {
            helper(node.left, res, path + node.val + "->");
        }
        if (node.right != null) {
            helper(node.right, res, path + node.val + "->");
        }
    }
}
