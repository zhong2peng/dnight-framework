import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ZHONGPENG769
 * @date 2019/9/17
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right = new TreeNode(3);
        print(treeNode);
        System.out.println();
        TreeNode result = solution.upsideDownBinaryTree(treeNode);
        print(result);
    }

    public static void print(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> layout = new LinkedList<>();
        layout.add(root);
        while (!layout.isEmpty()) {
            TreeNode pop = ((LinkedList<TreeNode>) layout).pollFirst();
            System.out.print(pop.val + ", ");
            if (pop.left != null) {
                layout.add(pop.left);
            }
            if (pop.right != null) {
                layout.add(pop.right);
            }
        }
    }
}
