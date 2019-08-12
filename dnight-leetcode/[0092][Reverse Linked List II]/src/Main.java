/**
 * Author: dnight
 * Date: 2019/8/12 22:29
 */
public class Main {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Solution solution = new Solution();
        ListNode ans = solution.reverseBetween(head, 2, 4);
        while (ans.next != null) {
            System.out.print(ans.val + ",");
            ans = ans.next;
        }
        System.out.println(ans.val);
    }
}
