/**
 * @author ZHONGPENG769
 * @date 2019/8/13
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        solution.recoverTree(root);
        System.out.println(root.val);
    }
}
