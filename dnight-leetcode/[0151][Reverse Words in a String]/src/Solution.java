/**
 * @author ZHONGPENG769
 * @date 2019/9/16
 */
public class Solution {

    /**
     * Given an input string, reverse the string word by word.
     * <p>
     * Example 1:
     * <p>
     * Input: "the sky is blue"
     * Output: "blue is sky the"
     * Example 2:
     * <p>
     * Input: "  hello world!  "
     * Output: "world! hello"
     * Explanation: Your reversed string should not contain leading or trailing spaces.
     * Example 3:
     * <p>
     * Input: "a good   example"
     * Output: "example good a"
     * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
     * <p>
     * <p>
     * Note:
     * <p>
     * A word is defined as a sequence of non-space characters.
     * Input string may contain leading or trailing spaces. However, your reversed string should not contain
     * leading or trailing spaces.
     * You need to reduce multiple spaces between two words to a single space in the reversed string.
     * <p>
     * <p>
     * Follow up:
     * <p>
     * For C programmers, try to solve it in-place in O(1) extra space.
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }

        char[] a = s.toCharArray();
        int n = a.length;

        // step1. reverse the whole string
        reverse(a, 0, n - 1);
        // step2. reverse each word
        reverseWords(a, n);
        // step3. clean up spaces
        return cleanSpaces(a, n);
    }

    private String cleanSpaces(char[] a, int n) {
        int i = 0;
        int j = 0;
        while (j < n) {
            //头部有空格，找到第一个字母
            while (j < n && a[j] == ' ') {
                j++;
            }
            // 开始填充
            while (j < n && a[j] != ' ') {
                a[i++] = a[j++];
            }
            // 找到后续第一个非空格
            while (j < n && a[j] == ' ') {
                j++;
            }
            if (j < n) {
                a[i++] = ' ';
            }
        }
        return new String(a).substring(0, i);
    }

    private void reverseWords(char[] a, int n) {
        int i = 0;
        int j = 0;
        while (i < n) {
            while (i < j || i < n && a[i] == ' ') {
                i++;
            }
            while (j < i || j < n && a[j] != ' ') {
                j++;
            }
            reverse(a, i, j - 1);
        }
    }

    private void reverse(char[] a, int i, int j) {
        while (i < j) {
            char t = a[i];
            a[i++] = a[j];
            a[j--] = t;
        }
    }
}
