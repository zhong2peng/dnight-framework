/**
 * @author ZHONGPENG769
 * @date 2019/7/8
 */
public class Main {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode head1 = new ListNode(0);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(2);

        Solution solution = new Solution();
        print(solution.rotateRight(head, 2));
        print(solution.rotateRight(head1, 4));

        Solution1 solution1 = new Solution1();
        print(solution1.rotateRight(head, 2));
        print(solution1.rotateRight(head1, 4));


    }

    public static void print(ListNode root) {
        ListNode temp = root;
        while (temp.next != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println(temp.val + "->null");
    }
}
