import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ZHONGPENG769
 * @date 2019/7/26
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(solution.largestRectangleArea(heights));

        Deque<Integer> stack = new LinkedList<>();
        for (int i = 1; i < 11; i++) {
            stack.push(i);
        }
        // pop 移出栈顶，peek 返回栈顶，poll 也是移除
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.poll());
        System.out.println(stack.size());
    }
}
