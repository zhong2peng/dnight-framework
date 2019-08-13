/**
 * @author ZHONGPENG769
 * @date 2019/8/13
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(solution.isValidBST(root));
    }
}
