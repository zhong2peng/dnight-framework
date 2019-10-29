/**
 * @author ZHONGPENG769
 * @date 2019/10/29
 */
public class Main {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(-3);
        treeNode.right.right = new TreeNode(11);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(2);
        treeNode.left.right.right = new TreeNode(1);
        treeNode.left.left.left = new TreeNode(3);
        treeNode.left.left.right = new TreeNode(-2);

        Solution solution = new Solution();
        int i = solution.pathSum(treeNode, 8);
        System.out.println(i);
    }
}
