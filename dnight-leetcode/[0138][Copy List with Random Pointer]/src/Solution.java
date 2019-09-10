/**
 * @author ZHONGPENG769
 * @date 2019/9/10
 */
public class Solution {

    /**
     * A linked list is given such that each node contains an additional random pointer
     * which could point to any node in the list or null.
     * <p>
     * Return a deep copy of the list.
     * <p>
     * 题目大意：
     * 一个单链表包含一个指向任意结点或者null的结点指针，返回这个链表的深拷贝
     * <p>
     * 解题思路：
     * 第一步：复制结点，复制的结点放在待复制的结点后，依然组成一个单链表
     * 第二步：串接随机指针
     * 第三步：拆分复制后的链表
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // step1
        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val, null, null);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        // step2
        cur = head;
        while (cur != null) {
            Node clone = cur.next;
            if (cur.random != null) {
                clone.random = cur.random.next;
            }
            cur = clone.next;
        }
        // step3
        cur = head;
        Node cloneHead = head.next;
        while (cur.next != null) {
            Node clone = cur.next;
            cur.next = clone.next;
            cur = clone;
        }
        return cloneHead;
    }

}
