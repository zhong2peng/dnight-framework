import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ZHONGPENG769
 * @date 2019/7/1
 */
public class Solution {

    /**
     * <pre>
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * 上面是由数组`[0,1,0,2,1,0,1,3,2,1,2,1]` 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
     *
     * 方法是找凹槽，怎么找呢？
     *
     * 1. 设置`slow,fast`两个下标代表凹槽的左右边界，一旦遇到`height[fast]>=height[slow]`的情况，计算凹槽的容积
     * 2. 上面情况是以右边界高度一定大于左边界为准的，当形成凹槽且左边界大于右边界时，要怎么记录呢？
     * 答案是设置`stopPoint`点，规则是当`height[fast]>height[stopPoint]`时有`stopPoint = fast`记录右边最高点；
     * 同时当fast越界时，会到`stopPoint`上
     *
     * 对于每个柱子，找到其左右两边最高的柱子，该柱子能容纳的面积就是min(max_left,max_right) - height。所以，
     * 1. 从左往右扫描一遍，对于每个柱子，求取左边最大值；
     * 2. 从右往左扫描一遍，对于每个柱子，求最大右值；
     * 3. 再扫描一遍，把每个柱子的面积并累加。
     * </pre>
     *
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        int ans = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int maxLeft = 0;
            int maxRight = 0;
            for (int j = i - 1; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for (int j = i + 2; j < size; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            ans += Math.min(maxLeft, maxRight) - height[i];
        }
        return ans;

    }

    public int trap2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int ans = 0;
        int size = height.length;
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];

        for (int i = 1; i < size - 1; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
            rightMax[size - i - 1] = Math.max(height[size - i], rightMax[size - i]);
        }

        for (int i = 1; i < size - 1; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    public int trap3(int[] height) {
        int ans = 0, current = 0;
        Deque<Integer> st = new LinkedList<>();
        while (current < height.length) {
            while (!st.isEmpty() && height[current] > height[st.getFirst()]) {
                int top = st.pop();
                if (st.isEmpty()) {
                    break;
                }
                int distance = current - st.peek() - 1;
                int boundedHeight = Math.min(height[current], height[st.peek()]) - height[top];
                ans += distance * boundedHeight;
            }
            st.push(current++);
        }
        return ans;
    }

    public int trap4(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        int leftMax = 0;
        int rightMax = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    ans += leftMax - height[left];
                }
                ++left;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    ans += rightMax - height[right];
                }
                --right;
            }
        }
        return ans;
    }
}
