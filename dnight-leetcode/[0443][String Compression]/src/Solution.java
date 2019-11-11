/**
 * @author ZHONGPENG769
 * @date 2019/11/6
 */
public class Solution {

    /**
     * Given an array of characters, compress it in-place.
     * The length after compression must always be smaller than or equal to the original array.
     * Every element of the array should be a character (not int) of length 1.
     * After you are done modifying the input array in-place, return the new length of the array.
     * <p>
     * <p>
     * Follow up:
     * Could you solve it using only O(1) extra space?
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input:
     * ["a","a","b","b","c","c","c"]
     * <p>
     * Output:
     * Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
     * <p>
     * Explanation:
     * "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
     * <p>
     * <p>
     * Example 2:
     * <p>
     * Input:
     * ["a"]
     * <p>
     * Output:
     * Return 1, and the first 1 characters of the input array should be: ["a"]
     * <p>
     * Explanation:
     * Nothing is replaced.
     * <p>
     * <p>
     * Example 3:
     * <p>
     * Input:
     * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
     * <p>
     * Output:
     * Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
     * <p>
     * Explanation:
     * Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
     * Notice each digit has it's own entry in the array.
     * <p>
     * <p>
     * Note:
     * <p>
     * All characters have an ASCII value in [35, 126].
     * 1 <= len(chars) <= 1000.
     *
     * @param chars
     * @return
     */
    public int compress1(char[] chars) {
        int res = 0;
        if (chars == null || chars.length == 0) {
            return res;
        }
        char last = chars[0];
        int repeat = 1;

        int changeIndex = 0;
        Boolean flag = true;

        for (int i = 1, len = chars.length; i < len; i++) {
            if (chars[i] == last && len - 1 != i) {
                repeat++;
                chars[i] = ' ';
                flag = false;
            } else {
                chars[changeIndex] = last;
                if (len - 1 == i && chars[i] == last) {
                    repeat++;
//                    chars[i] = ' ';
                    flag = false;
                }
                if (repeat >= 10) {
                    res += 1;
                    String repeatStr = String.valueOf(repeat);
                    res += repeatStr.length();
                    for (Character c : repeatStr.toCharArray()){
                        chars[++changeIndex] = c;
                    }
                } else {
                    if (repeat == 1) {
                        res += 1;
                    } else {
                        res += 2;
                        chars[++changeIndex] = (char) ('0' + repeat);
                    }
                }
                changeIndex++;
                if (len - 1 == i && changeIndex < len) {
                    chars[changeIndex] = chars[i];
                    if (chars[i] != last){
                        res += 1;
                    }
                }
                last = chars[i];
                repeat = 1;
            }
        }
        return res;
    }

    public int compress(char[] chars) {
        int indexAns = 0, index = 0;
        while (index < chars.length){
            char currentChar = chars[index];
            int count = 0;
            while (index < chars.length && chars[index] == currentChar){
                index++;
                count++;
            }
            chars[indexAns++] = currentChar;
            if (count != 1){
                for (char c:Integer.toString(count).toCharArray()){
                    chars[indexAns++] = c;
                }
            }
        }
        return indexAns;
    }

    public static void main(String[] args) {
        char[] chars = {'a','b','c'};
        System.out.println(new Solution().compress(chars));
        System.out.println(new Solution().compress1(chars));
    }
}
