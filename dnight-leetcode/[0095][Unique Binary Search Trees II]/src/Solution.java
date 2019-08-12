import java.util.ArrayList;
import java.util.List;

/**
 * Author: dnight
 * Date: 2019/8/12 23:51
 */
public class Solution {

    /**
     * Given an integer n, generate all structurally unique BST's
     * (binary search trees) that store values 1 ... n.
     * <p>
     * Input: 3
     * Output:
     * [
     * [1,null,3,2],
     * [3,2,null,1],
     * [3,1,null,null,2],
     * [2,1,3],
     * [1,null,2,null,3]
     * ]
     * Explanation:
     * The above output corresponds to the 5 unique BST's shown below:
     * <p>
     * 1         3     3      2      1
     * \       /     /      / \      \
     * 3     2     1      1   3      2
     * /     /       \                 \
     * 2     1         2                 3
     * 二分查找树，定义如下：
     * <p>
     * 1.若任意节点的左子树不空，则左子树上所有节点的值均小于它的根节点的值；
     * 2.若任意节点的右子树不空，则右子树上所有节点的值均大于它的根节点的值；
     * 3.任意节点的左、右子树也分别为二叉查找树；
     * 4.没有键值相等的节点。
     *
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }
        return getAns(1, n);
    }

    private List<TreeNode> getAns(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();
        if (start > end) {
            ans.add(null);
            return ans;
        }
        if (start == end) {
            TreeNode tree = new TreeNode(start);
            ans.add(tree);
            return ans;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = getAns(start, i - 1);
            List<TreeNode> rightTrees = getAns(i + 1, end);
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
