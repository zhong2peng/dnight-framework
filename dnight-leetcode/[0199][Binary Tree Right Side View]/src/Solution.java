import java.util.ArrayList;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/9/25
 */
public class Solution {

    /**
     * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes
     * you can see ordered from top to bottom.
     * <p>
     * Example:
     * <p>
     * Input: [1,2,3,null,5,null,4]
     * Output: [1, 3, 4]
     * Explanation:
     * <p>
     * 1            <---
     * /   \
     * 2     3         <---
     * \     \
     * 5     4       <---
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }

    private void rightView(TreeNode node, List<Integer> result, int curDepth) {
        if (node == null) {
            return;
        }
        if (curDepth == result.size()) {
            result.add(node.val);
        }
        rightView(node.right, result, curDepth + 1);
        rightView(node.left, result, curDepth + 1);
    }
}
