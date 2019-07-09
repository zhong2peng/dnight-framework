/**
 * @author ZHONGPENG769
 * @date 2019/7/8
 */
public class Solution {

    /**
     * Given a linked list, rotate the list to the right by k places, where k is non-negative.
     * <p>
     * Example 1:
     * <p>
     * Input: 1->2->3->4->5->NULL, k = 2
     * Output: 4->5->1->2->3->NULL
     * Explanation:
     * rotate 1 steps to the right: 5->1->2->3->4->NULL
     * rotate 2 steps to the right: 4->5->1->2->3->NULL
     * Example 2:
     * <p>
     * Input: 0->1->2->NULL, k = 4
     * Output: 2->0->1->NULL
     * Explanation:
     * rotate 1 steps to the right: 2->0->1->NULL
     * rotate 2 steps to the right: 1->2->0->NULL
     * rotate 3 steps to the right: 0->1->2->NULL
     * rotate 4 steps to the right: 2->0->1->NULL
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || n < 1) {
            return head;
        }
        int length = 1;
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
            length++;
        }
        n = length - n % length;
        p.next = head;
        for (int i = 0; i < n; i++) {
            p = p.next;
        }
        head = p.next;
        p.next = null;
        return head;
    }
}
