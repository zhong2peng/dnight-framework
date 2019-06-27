/**
 * @author ZHONGPENG769
 * @date 2019/4/1
 */
public class Solution {

    /**
     * <pre>
     * 原题
     * You are given two linked lists representing two non-negative numbers.
     * The digits are stored in reverse order and each of their nodes contain
     * a single digit. Add the two numbers and return it as a linked list.
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     *
     * 题目大意
     * 有两个单链表，代表两个非负数，每一个节点代表一个数位，数字是反向存储的，
     * 即第一个结点表示最低位，最后一个结点表示最高位。求两个数的相加和，并且以链表形式返回。
     *
     * 解题思路
     * 对两个链表都从第一个开始处理，进行相加，结果再除以10求商，作为下一位相加的进位，
     * 同时记录余数，作为本位的结果，一直处理，直到所有的结点都处理完。
     * </pre>
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        if (l1 == null){
            return l2;
        }

        if (l2 == null){
            return l1;
        }

        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode root = new ListNode(0);
        ListNode r = root;
        root.next = l1;

        int carray = 0;
        int sum;
        while (p1 != null && p2 != null){
            sum = p1.val + p2.val + carray;
            p1.val = sum % 10;
            carray = sum / 10;

            r.next = p1;
            r = p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p1 == null){
            r.next = p2;
        }else{
            r.next = p1;
        }

        if (carray == 1){
            while (r.next != null){
                sum = r.next.val + carray;
                r.next.val = sum % 10;
                carray = sum / 10;
                r = r.next;
            }

            if (carray == 1){
                r.next = new ListNode(1);
            }
        }
        return root.next;
    }
}
