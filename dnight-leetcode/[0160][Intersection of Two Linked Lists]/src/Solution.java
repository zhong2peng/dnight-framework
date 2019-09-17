/**
 * @author ZHONGPENG769
 * @date 2019/9/17
 */
public class Solution {

    /**
     * Write a program to find the node at which the intersection of two singly linked lists begins.
     * <p>
     * For example, the following two linked lists:
     * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
     * Output: Reference of the node with value = 8
     * Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
     * From the head of A, it reads as [4,1,8,4,5]. From the head of B,
     * it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A;
     * There are 3 nodes before the intersected node in B.
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while (a != b) {
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
