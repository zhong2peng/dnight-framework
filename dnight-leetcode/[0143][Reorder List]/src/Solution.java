/**
 * @author ZHONGPENG769
 * @date 2019/9/12
 */
public class Solution {

    /**
     * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
     * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
     * <p>
     * You may not modify the values in the list's nodes, only nodes itself may be changed.
     * <p>
     * Example 1:
     * <p>
     * Given 1->2->3->4, reorder it to 1->4->2->3.
     * Example 2:
     * <p>
     * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
     * <p>
     * 这道链表重排序问题可以拆分为以下三个小问题：
     * 1. 使用快慢指针来找到链表的中点，并将链表从中点处断开，形成两个独立的链表。
     * 2. 将第二个链翻转。
     * 3. 将第二个链表的元素间隔地插入第一个链表中。
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        // second last node
        ListNode slast = head;
        // last node
        ListNode last = head.next;
        while (last.next != null) {
            last = last.next;
            slast = slast.next;
        }

        // Insert the last node right after the first node
        ListNode tmp = head.next;
        head.next = last;
        last.next = tmp;

        slast.next = null;
        reorderList(tmp);
    }
}
