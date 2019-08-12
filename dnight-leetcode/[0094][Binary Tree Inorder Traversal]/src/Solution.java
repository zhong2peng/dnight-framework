import java.util.ArrayList;
import java.util.List;

/**
 * Author: dnight
 * Date: 2019/8/12 23:43
 */
public class Solution {

    /**
     * Given a binary tree, return the inorder traversal of its nodes' values.
     * 中序遍历
     * Input: [1,null,2,3]
     * 1
     * \
     * 2
     * /
     * 3
     * <p>
     * Output: [1,3,2]
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        getAns(root, ans);
        return ans;
    }

    private void getAns(TreeNode node, List<Integer> ans) {
        if (node == null) {
            return;
        }
        getAns(node.left, ans);
        ans.add(node.val);
        getAns(node.right, ans);
    }
}
