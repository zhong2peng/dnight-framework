import java.util.Stack;

/**
 * @author ZHONGPENG769
 * @date 2019/10/9
 */
public class Solution {

    /**
     * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
     * You may assume each number in the sequence is unique.
     * Consider the following binary search tree:
     * <p>
     * 5
     * / \
     * 2   6
     * / \
     * 1  3
     * Example 1:
     * <p>
     * Input: [5,2,6,1,3]
     * Output: false
     * Example 2:
     * <p>
     * Input: [5,2,1,3,6]
     * Output: true
     * Follow up:
     * Could you do it using only constant space complexity?
     * <p>
     * 利用stack模拟preoreder，stack存放左子树
     * 遇到比stack top还要大，说明遇到了以top为root的右子树，把左子树连 root都poo出来
     * low是当前的lower bound，pop出来说明左边遍历玩了，不可能出现更小的了
     *
     * @param preorder
     * @return
     */
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Stack<Integer> stk = new Stack<>();
        for (int num : preorder) {
            if (num < low) {
                return false;
            }
            while (!stk.isEmpty() && stk.peek() < num) {
                low = stk.pop();
            }
            stk.push(num);
        }
        return true;
    }

    // array 本身实现stack的功能
    public boolean verifyPreorder1(int[] preorder) {
        int index = -1;
        int low = Integer.MIN_VALUE;
        for (int num : preorder) {
            if (num < low) {
                return false;
            }
            while (index >= 0 && preorder[index] < num) {
                low = preorder[index--];
            }
            preorder[++index] = num;
        }
        return true;
    }
}
