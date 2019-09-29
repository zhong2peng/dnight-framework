/**
 * @author ZHONGPENG769
 * @date 2019/9/29
 */
public class Solution {

    /**
     * Given a singly linked list, determine if it is a palindrome.
     * <p>
     * Example 1:
     * <p>
     * Input: 1->2
     * Output: false
     * Example 2:
     * <p>
     * Input: 1->2->2->1
     * Output: true
     * <p>
     * 快慢指针找到终点
     * 反转链表方法
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }

        slow = reverse(slow);
        while (slow != null && head.val == slow.val) {
            slow = slow.next;
            head = head.next;
        }
        return slow == null;
    }

    private ListNode reverse(ListNode slow) {
        ListNode prev = null;
        while (slow != null) {
            ListNode tmp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = tmp;
        }
        return prev;
    }
}
