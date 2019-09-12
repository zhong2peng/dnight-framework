/**
 * @author ZHONGPENG769
 * @date 2019/9/12
 */
public class Solution {

    /**
     * Sort a linked list using insertion sort.
     * <p>
     * A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
     * With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
     * <p>
     * <p>
     * Algorithm of Insertion Sort:
     * <p>
     * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
     * At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
     * It repeats until no input elements remain.
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
     * 指针的插入排序是一种简单直观的排序算法，它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从前向后扫描，
     * 找到相应位置并插入。插入排序的实现上，通常采用 in-place 排序（即只需用到O(1)的额外空间的排序）。
     * 用指针 p 逐一向后遍历
     * <p>
     * 0. 申请一个 dummyHead 节点，其下一个节点指向头结点。如果要在头结点出插入，dummyHead 会给我们带来便利
     * <p>
     * 1. 当 p 的值不大于下一节点值，就进行遍历下一节点
     * <p>
     * 2. 当 p 的值大于下一节点，那么就将p 的下一节点取出，从前向后扫描，在第一个比它的值大的节点之前插入该节点
     *
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode after = head.next;
        ListNode originPrev = head;
        while (after != null) {
            ListNode prev = originPrev;
            ListNode current = after;
            current.next = prev;
            after = after.next;
        }
        return null;
    }
}
