/**
 * @author ZHONGPENG769
 * @date 2019/9/5
 */
public class Solution {

    /**
     * You are given a perfect binary tree
     * where all leaves are on the same level,
     * and every parent has two children. The binary tree has the following definition:
     * <p>
     * struct Node {
     * int val;
     * Node *left;
     * Node *right;
     * Node *next;
     * }
     * Populate each next pointer to point to its next right node.
     * If there is no next right node, the next pointer should be set to NULL.
     * <p>
     * For example,
     * Given the following perfect binary tree,
     * 1
     * /  \
     * 2    3
     * / \  / \
     * 4  5  6  7
     * <p>
     * After calling your function, the tree should look like:
     * <p>
     * 1 -> NULL
     * /  \
     * 2 -> 3 -> NULL
     * / \  / \
     * 4->5->6->7 -> NULL
     * Initially, all next pointers are set to NULL.
     * <p>
     * 基本思路：
     * 将树的每一层节点用next串起来。这样每一层也会形成一个单链表。
     * 而每层的链表头，则是，根的左孩子，左孩子，左孩子。
     * 利用双循环，外层循环，沿着根的左孩子，一直向下。
     * 内层循环，负责将下一层的节点串起来。
     * <p>
     * 即，将自己右孩子放到左孩子的next上，而右孩子，则可通过自己的next指针，找到右邻居。
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        Node node;
        Node result = root;
        while (root != null && root.left != null) {
            // 每一层的第一个节点
            node = root;
            while (node != null) {
                node.left.next = node.right;
                if (node.next != null) {
                    node.right.next = node.next.left;
                }
                //移动到同层的下一个节点
                node = node.next;
            }
            //移动到下一层的第一个节点
            root = root.left;
        }
        return result;
    }
}
