/**
 * @author ZHONGPENG769
 * @date 2019/10/11
 */
public class Solution {

    /**
     * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative
     * order of the non-zero elements.
     * <p>
     * Example:
     * <p>
     * Input: [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     * Note:
     * <p>
     * You must do this in-place without making a copy of the array.
     * Minimize the total number of operations.
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int insertPos = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    public void moveZeroes1(int[] nums) {
        int left = 0, right = 0, len = nums.length;
        while (left < len) {
            while (left < len && nums[left] != 0) {
                left++;
                right++;
            }
            while (right < len && nums[right] == 0) {
                right++;
            }
            for (int i = left; i < right; i++) {
                nums[i] = nums[right + i - left];
                nums[right + i - left] = 0;
                if (right + i - left == len - 1) {
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-959151711,
                623836953,
                209446690,
                -1950418142,
                1339915067,
                -733626417,
                481171539,
                -2125997010,
                -1225423476,
                1462109565,
                147434687,
                -1800073781,
                -1431212205,
                -450443973,
                50097298,
                753533734,
                -747189404,
                -2070885638,
                0,
                -1484353894,
                -340296594,
                -2133744570,
                619639811,
                -1626162038,
                669689561,
                0,
                112220218,
                502447212,
                -787793179,
                0,
                -726846372,
                -1611013491,
                204107194,
                1605165582,
                -566891128,
                2082852116,
                0,
                532995238,
                -1502590712,
                0,
                2136989777,
                -2031153343,
                371398938,
                -1907397429,
                342796391,
                609166045,
                -2007448660,
                -1096076344,
                -323570318,
                0,
                -2082980371,
                2129956379,
                -243553361,
                -1549960929,
                1502383415,
                0,
                -1394618779,
                694799815,
                78595689,
                -1439173023,
                -1416578800,
                685225786,
                -333502212,
                -1181308536,
                -380569313,
                772035354,
                0,
                -915266376,
                663709718,
                1443496021,
                -777017729,
                -883300731,
                -387828385,
                1907473488,
                -725483724,
                -972961871,
                -1255712537,
                383120918,
                1383877998,
                1722751914,
                0,
                -1156050682,
                1952527902,
                -560244497,
                1304305692,
                1173974542,
                -1313227247,
                -201476579,
                -298899493,
                -1828496581,
                -1724396350,
                1933643204,
                1531804925,
                1728655262,
                -955565449,
                0,
                -69843702,
                -461760848,
                268336768,
                1446130876};
        solution.moveZeroes(nums);
        for (int i : nums) {
            System.out.print(i + ",");
        }
    }
}
