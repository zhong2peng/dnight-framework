/**
 * Author: dnight
 * Date: 2019/8/12 22:28
 */
public class Solution {

    /**
     * Reverse a linked list from position m to n. Do it in one-pass.
     * Note: 1 ≤ m ≤ n ≤ length of list.
     * <p>
     * Input: 1->2->3->4->5->NULL, m = 2, n = 4
     * Output: 1->4->3->2->5->NULL
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int count = 0;

        ListNode left1 = null;
        ListNode left2 = null;
        ListNode pre = dummy;

        while (head != null) {
            count++;
            if (count == m) {
                left1 = pre;
                left2 = head;
            }
            if (count > m && count < n) {
                ListNode temp = head.next;
                head.next = pre;
                pre = head;
                head = temp;
                continue;
            }
            if (count == n) {
                left2.next = head.next;
                head.next = pre;
                left1.next = head;
                break;
            }
            head = head.next;
            pre = pre.next;
        }
        return dummy.next;
    }
}
