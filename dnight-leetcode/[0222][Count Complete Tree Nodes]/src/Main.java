/**
 * @author ZHONGPENG769
 * @date 2019/9/27
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(1 << 8);

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(6);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        Solution solution = new Solution();
        int i = solution.countNodes(treeNode);
        System.out.println(i);
    }
}
