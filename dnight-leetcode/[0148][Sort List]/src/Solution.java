/**
 * @author ZHONGPENG769
 * @date 2019/9/16
 */
public class Solution {

    /**
     * Sort a linked list in O(n log n) time using constant space complexity.
     * <p>
     * Example 1:
     * <p>
     * Input: 4->2->1->3
     * Output: 1->2->3->4
     * Example 2:
     * <p>
     * Input: -1->5->3->4->0
     * Output: -1->0->3->4->5
     * <p>
     * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
     * 归并排序
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // step1, cut the list to two halves
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        // step2, sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // step3, merge l1 and l2
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        ListNode p = l;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return l.next;
    }
}
