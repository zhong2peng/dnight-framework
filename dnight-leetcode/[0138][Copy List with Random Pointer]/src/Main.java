/**
 * @author ZHONGPENG769
 * @date 2019/9/10
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        Node node = solution.copyRandomList(n1);
        print(node);
    }

    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }

        System.out.println("null");
    }
}
