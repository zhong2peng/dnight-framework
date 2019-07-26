/**
 * @author ZHONGPENG769
 * @date 2019/7/26
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        ListNode partition = solution.partition(head, 3);
        while (partition.next != null) {
            System.out.print(partition.val + ", ");
            partition = partition.next;
        }
        System.out.println(partition.val);
    }
}
