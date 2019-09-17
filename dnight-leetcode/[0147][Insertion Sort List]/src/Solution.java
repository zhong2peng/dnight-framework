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
        if (head == null) {
            return null;
        }
        return insertionOnNode(head, head);
    }

    /**
     * 从链表头部开始遍历，记录当前已完成插入排序的最后一个节点。然后进行以下操作：
     * - 获得要插入排序的节点 curNode 、其上一个节点 perNode 、其下一个节点 nextNode;
     * - 判断 curNode 是否应插入在 perNode 之后，若否，将 curNode 从链表中移除准备插入，
     * 若是，无需进一步操作，此时已排序的最后一个节点为 curNode;
     * - 在链表头节点前增加一个节点，应对 curNode 插入位置在 头节点之前的情况;
     * - 从头节点开始遍历，找到curNode 的插入位置，进行插入;
     * - 此时已排序的最后一个节点仍为 perNode ，重复以上操作直至链表末尾。
     *
     * @param head
     * @param node
     * @return
     */
    private ListNode insertionOnNode(ListNode head, ListNode node) {
        if (head == null || node == null || node.next == null) {
            return head;
        }
        ListNode perNode = node;
        ListNode curNode = node.next;
        ListNode nextNode = curNode.next;
        if (node.val <= curNode.val) {
            return insertionOnNode(head, curNode);
        } else {
            // 大于最后一个节点
            node.next = nextNode;
        }

        ListNode pNode = new ListNode(0);
        pNode.next = head;
        head = pNode;
        while (pNode.next.val <= curNode.val) {
            pNode = pNode.next;
        }
        // 恢复并插入列表
        ListNode nNode = pNode.next;
        pNode.next = curNode;
        curNode.next = nNode;
        // 此时已排序的最后一个节点仍然为perNode
        return insertionOnNode(head.next, perNode);
    }
}
