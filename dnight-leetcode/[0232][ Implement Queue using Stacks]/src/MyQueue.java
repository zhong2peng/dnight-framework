import java.util.Stack;

/**
 * @author ZHONGPENG769
 * @date 2019/9/29
 */
public class MyQueue {

    Stack<Integer> stack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack.add(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        Integer tmp = stack.firstElement();
        stack.remove(tmp);
        return tmp;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return stack.firstElement();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack.isEmpty();
    }
}
