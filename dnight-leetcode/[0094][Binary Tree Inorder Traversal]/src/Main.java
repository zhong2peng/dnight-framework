import java.util.List;

/**
 * Author: dnight
 * Date: 2019/8/12 23:43
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> list = solution.inorderTraversal(root);
        for (Integer val : list) {
            System.out.print(val + ",");
        }
    }
}
