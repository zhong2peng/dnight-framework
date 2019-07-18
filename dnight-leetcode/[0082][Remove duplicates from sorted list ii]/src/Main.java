/**
 * @author ZHONGPENG769
 * @date 2019/7/18
 */
public class Main {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(3);
        root.next.next.next.next = new ListNode(4);
        root.next.next.next.next.next = new ListNode(4);
        root.next.next.next.next.next.next = new ListNode(5);

        Solution solution = new Solution();
        ListNode listNode = solution.deleteDuplicates(root);
        while (listNode.next != null) {
            System.out.print(listNode.val + ",");
            listNode = listNode.next;
        }
        System.out.println(listNode.val);
    }
}
