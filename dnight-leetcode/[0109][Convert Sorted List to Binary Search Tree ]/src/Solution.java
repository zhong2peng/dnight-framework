/**
 * @author ZHONGPENG769
 * @date 2019/9/3
 */
public class Solution {

    /**
     * Given a singly linked list where elements are sorted in ascending order,
     * convert it to a height balanced BST.
     * <p>
     * For this problem, a height-balanced binary tree is defined as a binary tree
     * in which the depth of the two subtrees of every node never differ by more than 1.
     * <p>
     * Example:
     * <p>
     * Given the sorted linked list: [-10,-3,0,5,9],
     * <p>
     * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
     * <p>
     * 0
     * / \
     * -3   9
     * /   /
     * -10  5
     * <p>
     * 题目大意：
     * * 给定一个升序的单链表，将它转换成一颗高度平衡的二叉树
     * *
     * * 解题思路：
     * * 解法一：将单链表中的值存入一个数组中，通过数组来构建二叉树，算法时间复杂度是：O(n)，空间复杂度是：O(n)
     * * 解法二：采用递归的方式，
     * *      （一）找中间结点，构建根结点，
     * *      （二）中间结点左半部分构建左子树，
     * *      （三）中间结点的右部分构建右子树
     * * 题采用第二种解法
     *
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        //每次移动2个位置
        ListNode fast = head.next.next;
        //记录中间节点
        ListNode mid = head;
        while (fast != null && fast.next != null) {
            mid = mid.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(mid.val);
        root.right = sortedListToBST(mid.next.next);
        ListNode midNext = mid.next;
        //断开单链表（原来单链表会被破坏）
        mid.next = null;
        //构建左子树
        root.left = sortedListToBST(head);
        // 重新将链表接好
        mid.next = midNext;
        return root;
    }
}
