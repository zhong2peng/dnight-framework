/**
 * @author ZHONGPENG769
 * @date 2019/9/12
 */
public class Solution {

    /**
     * Given a linked list, determine if it has a cycle in it.
     * <p>
     * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed)
     * in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;

        while (slow != null && quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
            //注意头结点
            if (quick == slow) {
                return true;
            }
        }
        return false;
    }
}
