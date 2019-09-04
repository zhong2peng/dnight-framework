/**
 * @author ZHONGPENG769
 * @date 2019/9/2
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] inorder = {1, 2, 3, 4};
        int[] postorder = {3, 2, 4, 1};

        TreeNode root = solution.buildTree(inorder, postorder);
        print(root);
        System.out.println();
        int[] inorder1 = {9, 3, 15, 20, 7};
        int[] postorder1 = {9, 15, 7, 20, 3};
        TreeNode root1 = solution.buildTree(inorder1, postorder1);
        print(root1);
    }

    public static void print(TreeNode root) {
        if (root != null) {
            print(root.left);
            System.out.print(root.val + " ");
            print(root.right);
        }
    }
}
