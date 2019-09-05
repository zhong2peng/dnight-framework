import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/9/5
 */
public class Solution {

    /**
     * Given a binary tree
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
     * Initially, all next pointers are set to NULL.
     * For example,
     * Given the following binary tree,
     * 1
     * /  \
     * 2    3
     * / \    \
     * 4   5    7
     * After calling your function, the tree should look like:
     * 1 -> NULL
     * /  \
     * 2 -> 3 -> NULL
     * / \    \
     * 4-> 5 -> 7 -> NULL
     * <p>
     * 题目大意：
     * 给你一棵二叉树，每个树节点中增加了一个next指针，指向了其同一层的相邻的右边的节点。将同层的结点都串起来
     * <p>
     * 解题思路：
     * 对树进行层次遍历，将每一层串接起来
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        Node result = root;
        while (root != null) {
            List<Node> layout = new LinkedList<>();
            Node preNode = null;
            Node curNode;
            layout.add(root);
            int curNum = 1;
            int nextNum = 0;
            while (layout.size() > 0) {
                curNode = layout.remove(0);
                curNum--;
                if (curNode.left != null) {
                    layout.add(curNode.left);
                    nextNum++;
                }
                if (curNode.right != null) {
                    layout.add(curNode.right);
                    nextNum++;
                }
                if (curNum == 0) {
                    Iterator<Node> iterator = layout.iterator();
                    if (iterator.hasNext()) {
                        preNode = iterator.next();
                        while (iterator.hasNext()) {
                            curNode = iterator.next();
                            preNode.next = curNode;
                            preNode = curNode;
                        }
                    }
                    curNum = nextNum;
                    nextNum = 0;
                }
            }
        }
        return result;
    }

    public Node connect1(Node root) {
        Node cur = root;
        while (cur != null) {
            // 初始的链表头，不能放外面，每一层的最前方都必须要有一个虚拟头结点，且不一样
            // 每遍历一层，虚拟头结点都会再创建一个，然后cur置为之前的最左结点
            Node dummyHead = new Node();
            Node pre = dummyHead;
            //遍历当前层
            while (cur != null) {
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            //转移到下一层
            cur = dummyHead.next;
        }
        return root;
    }
}
