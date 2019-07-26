/**
 * @author ZHONGPENG769
 * @date 2019/7/26
 */
public class Solution {

    /**
     * <pre>
     * 原题
     * Given a linked list and a value x, partition it such that all nodes less
     * than x come before nodes greater than or equal to x.
     * You should preserve the original relative order of the nodes in each of
     * the two partitions.
     *
     * For example,
     * Given 1->4->3->2->5->2 and x = 3,
     * return 1->2->2->4->3->5.
     *
     * 题目大意
     * 给定一个单链表和一个值x，将链表分成小于等于x的部分和大于x的部分。同时保持链表原来的相对顺序。
     *
     * 解题思路
     * 创建两个链表a，b，将原来链表中的每个结点，小于等于x的结点放在a链表的末尾，如果是大于就放在b的
     * 末尾，最后将b的头结点接到a末尾。
     * </pre>
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode le = new ListNode(0);
        ListNode ge = new ListNode(0);
        ListNode t1 = le;
        ListNode t2 = ge;
        ListNode p = head;

        while (p != null) {
            if (p.val < x) {
                t1.next = p;
                t1 = p;
            } else {
                t2.next = p;
                t2 = p;
            }
            p = p.next;
        }
        t2.next = null;
        if (t1 != le) {
            t1.next = ge.next;
            head = le.next;
        } else {
            head = ge.next;
        }
        return head;
    }
}
