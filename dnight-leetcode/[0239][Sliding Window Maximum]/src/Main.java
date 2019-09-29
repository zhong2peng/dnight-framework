import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ZHONGPENG769
 * @date 2019/9/29
 */
public class Main {

    public static void main(String[] args) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.peekLast());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
    }
}
