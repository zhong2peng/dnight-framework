/**
 * @author ZHONGPENG769
 * @date 2019/7/18
 */
public class Solution {

    /**
     * <pre>
     * 原题
     * Given a sorted linked list, delete all duplicates such that each element appear only once.
     * For example,
     * Given 1->1->2, return 1->2.
     * Given 1->1->2->3->3, return 1->2->3.
     *
     * 题目大意
     * 给定一个单链表，删除重复的元素，相同的只保留一个。
     *
     * 解题思路
     * 使用一个指针指向链表的头，如果下一个与当前的结点相等则删除，直到遇到一个不相同的，则指针指向这
     * 个新的结点，重复操作，直到所有的结点都处理完。
     * </pre>
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode p = head;
        ListNode q = root;
        while (p != null && p.next != null) {
            while (p.next != null && p.val == p.next.val) {
                p = p.next;
            }
            q.next = p;
            q = q.next;
            p = p.next;

        }
        return root.next;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        ListNode point;
        ListNode tail = head;
        if (head != null) {
            point = head.next;
            while (point != null) {
                if (tail.val != point.val) {
                    tail.next = point;
                    tail = tail.next;
                }
                point = point.next;
            }
            tail.next = null;
        }
        return head;
    }
}
