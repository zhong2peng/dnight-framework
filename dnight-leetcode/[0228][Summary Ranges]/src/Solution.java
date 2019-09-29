import java.util.LinkedList;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/9/29
 */
public class Solution {

    /**
     * Given a sorted integer array without duplicates, return the summary of its ranges.
     * <p>
     * Example 1:
     * <p>
     * Input:  [0,1,2,4,5,7]
     * Output: ["0->2","4->5","7"]
     * Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
     * Example 2:
     * <p>
     * Input:  [0,2,3,4,6,8,9]
     * Output: ["0","2->4","6","8->9"]
     * Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
     *
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        if (nums.length == 1) {
            res.add(String.valueOf(nums[0]));
            return res;
        }
        int prefer = nums[0];
        int start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (prefer + 1 != nums[i]) {
                if (start == prefer) {
                    res.add(String.valueOf(start));
                } else {
                    res.add(start + "->" + prefer);
                }
                start = nums[i];
            }
            prefer = nums[i];
        }
        if (start == prefer) {
            res.add(String.valueOf(start));
        } else {
            res.add(start + "->" + prefer);
        }
        return res;
    }
}
