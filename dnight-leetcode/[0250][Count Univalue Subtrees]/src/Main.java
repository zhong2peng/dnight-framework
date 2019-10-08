/**
 * @author ZHONGPENG769
 * @date 2019/10/8
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(5);
        treeNode.right.right = new TreeNode(5);
        treeNode.left.left = new TreeNode(5);
        treeNode.left.right = new TreeNode(5);
        int i = solution.countUnivalSubtrees(treeNode);
        System.out.println(i);
    }
}
