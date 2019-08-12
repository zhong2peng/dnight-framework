import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: dnight
 * Date: 2019/8/12 22:05
 */
public class Solution {

    /**
     * Given a collection of integers that might contain duplicates, nums,
     * return all possible subsets (the power set).
     * Note: The solution set must not contain duplicate subsets.
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        getAns(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    //回溯法
    private void getAns(int[] nums, int start, ArrayList<Integer> temp, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            getAns(nums, i + 1, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }
}
