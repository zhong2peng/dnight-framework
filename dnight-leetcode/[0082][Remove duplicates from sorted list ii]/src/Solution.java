/**
 * @author ZHONGPENG769
 * @date 2019/7/18
 */
public class Solution {

    /**
     * <pre>
     * 原题
     * Given a sorted linked list, delete all nodes that have duplicate numbers,
     * leaving only distinct numbers from the original list.
     * For example,
     * Given 1->2->3->3->4->4->5, return 1->2->5.
     * Given 1->1->1->2->3, return 2->3.
     *
     * 题目大意
     * 给定一个排好序的单链表，删除所有重复的元素。只留下只有一个值的元素。
     *
     * 解题思路
     * 给链表接上一个辅助结点root，root接到原来的头部，引用这个头部和辅助的指针，对重重的元素进行删除。
     * </pre>
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        //头结点
        ListNode root = new ListNode(0);
        root.next = head;
        //当前节点
        ListNode p = head;
        //记录最后一个没有重复的元素，开始指向头结点
        ListNode q = root;

        //元素重复个数
        int delta = 0;
        while (p != null && p.next != null) {
            //如果相邻两个数相等
            if (p.val == p.next.val) {
                delta++;
                //移动到下一个节点
                p = p.next;
            } else {
                //值为p.val的节点没有重复
                if (delta == 0) {
                    //连接到没有重复的元素
                    q.next = p;
                    q = p;
                    p = p.next;
                } else {
                    p = p.next;
                    //去掉重复的元素
                    q.next = p.next;
                    delta = 0;
                }
            }
        }
        if (delta != 0) {
            q.next = null;
        } else {
            q.next = p;
        }
        return root.next;
    }

}
