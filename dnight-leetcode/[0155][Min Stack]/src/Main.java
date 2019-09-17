/**
 * @author ZHONGPENG769
 * @date 2019/9/17
 */
public class Main {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();  // Returns -3.
        minStack.pop();
        minStack.top();      // Returns 0.
        minStack.getMin();  // Returns -2.
    }
}
