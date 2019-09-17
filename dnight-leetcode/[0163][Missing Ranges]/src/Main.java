import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/9/17
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 1, 3, 50, 75};
        int lower = 0;
        int upper = 99;
        List<String> missingRanges = solution.findMissingRanges(nums, lower, upper);
        for (String tmp : missingRanges) {
            System.out.print(tmp + ", ");
        }
    }
}
