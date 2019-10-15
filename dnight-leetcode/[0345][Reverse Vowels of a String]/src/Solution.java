/**
 * @author ZHONGPENG769
 * @date 2019/10/15
 */
public class Solution {

    /**
     * Write a function that takes a string as input and reverse only the vowels of a string.
     * <p>
     * Example 1:
     * <p>
     * Input: "hello"
     * Output: "holle"
     * Example 2:
     * <p>
     * Input: "leetcode"
     * Output: "leotcede"
     *
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        String target = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            while (!target.contains(chars[left] + "")) {
                left++;
            }
            while (!target.contains(chars[right] + "")) {
                right--;
            }
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
        return new String(chars);
    }
}
