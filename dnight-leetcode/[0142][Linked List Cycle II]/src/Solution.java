/**
 * @author ZHONGPENG769
 * @date 2019/9/12
 */
public class Solution {

    /**
     * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
     * <p>
     * To represent a cycle in the given linked list, we use an integer pos which represents the position
     * (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
     * <p>
     * Note: Do not modify the linked list.
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                ListNode start = head;
                while (start != slow) {
                    start = start.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
