/**
 * @author ZHONGPENG769
 * @date 2019/9/12
 */
public class Main {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(1);
        n1.next = n2;
        n1.next.next = n3;
        n1.next.next.next = n4;
        n1.next.next.next.next = n5;
        Solution solution = new Solution();
        ListNode listNode = solution.insertionSortList(n1);
        print(listNode);
//        ListNode test = test(n1);
//        print(test);
//        System.out.println();
//        print(n1);

    }

    public static void print(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
    }

    public static ListNode test(ListNode root) {
        ListNode head = root;
        head.next = null;
        return root;
    }
}
