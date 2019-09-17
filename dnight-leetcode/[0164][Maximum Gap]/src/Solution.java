/**
 * @author ZHONGPENG769
 * @date 2019/9/17
 */
public class Solution {

    /**
     * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
     * <p>
     * Return 0 if the array contains less than 2 elements.
     * <p>
     * Example 1:
     * <p>
     * Input: [3,6,9,1]
     * Output: 3
     * Explanation: The sorted form of the array is [1,3,6,9], either
     * (3,6) or (6,9) has the maximum difference 3.
     * Example 2:
     * <p>
     * Input: [10]
     * Output: 0
     * Explanation: The array contains less than 2 elements, therefore return 0.
     * Note:
     * <p>
     * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed
     * integer range.
     * Try to solve it in linear time/space.
     * <p>
     * [Hard]
     *
     * @param nums
     * @return
     */
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        // m is the maximal number in nums
        // 1. The first step is to find the maximum value in nums array, it will
        //    be the threshold to end while loop.
        int m = nums[0];
        for (int i = 1; i < nums.length; i++) {
            m = Math.max(m, nums[i]);
        }
        // 1, 10, 100, 1000 ...
        int exp = 1;
        // 10 digits
        int R = 10;
        int[] aux = new int[nums.length];

        // 2. Then use the radix sort algorithm to sort based on each digit from Least Significant Bit
        //    (LSB) to Most Significant Bit (MSB), that's exactly what's showing
        //    in the link.
        while (m / exp > 0) {
            int[] count = new int[R];
            // (nums[i] / exp) % 10 is used to get the digit, for each digit, basically the digit itself serves as the index to
            // access the count array. Count array stores the index to access aux
            // array which stores the numbers after sorting based on the current
            // digit.
            for (int i = 0; i < nums.length; i++) {
                count[(nums[i] / exp) % 10]++;
            }

            for (int i = 1; i < count.length; i++) {
                count[i] += count[i - 1];
            }

            for (int i = nums.length - 1; i >= 0; i--) {
                aux[--count[(nums[i] / exp) % 10]] = nums[i];
            }

            for (int i = 0; i < nums.length; i++) {
                nums[i] = aux[i];
            }
            exp *= 10;
        }
        int max = 0;
        // 4. find the maximum gap from sorted array
        for (int i = 1; i < aux.length; i++) {
            max = Math.max(max, aux[i] - aux[i - 1]);
        }
        return max;
    }
}
