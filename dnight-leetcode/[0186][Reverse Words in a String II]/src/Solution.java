/**
 * @author ZHONGPENG769
 * @date 2019/9/19
 */
public class Solution {

    /**
     * Given an input string, reverse the string word by word.
     * A word is defined as a sequence of non-space characters.
     * The input string does not contain leading or trailing spaces and the words are always separated by a single space.
     * For example,
     * Given s = "the sky is blue",
     * return "blue is sky the".
     * Could you do it in-place without allocating extra space?
     * <p>
     * 跟Reverse Words in a String很类似，但是这里要求in-place，也就是说不需要开辟额外空间。
     * <p>
     * [分析]
     * 该题在LeetCode中假设开头和结尾没有空格，而且单词之间只有一个空格。但其实不需要这些假设也是可以的，就是代码会比较复杂。
     * 思路就是两步走，第一步就是将整个字符串翻转。然后从头逐步扫描，将每个遇到单词再翻转过来。
     * <p>
     * [注意事项]
     * 1）如果是Java，应该跟面试官指出String是immutable，所以需要用char array来做。
     * 2）follow-up问题：k-step reverse。也就是在第二部翻转的时候，把k个单词看作一个长单词，进行翻转。
     *
     * @param s
     */
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length);
        for (int i = 0, j = 0; j <= s.length; j++) {
            if (j == s.length || s[j] == ' ') {
                reverse(s, i, j);
                i = j + 1;
            }
        }
    }

    private void reverse(char[] s, int begin, int end) {
        for (int i = 0; i < (end - begin) / 2; i++) {
            char temp = s[begin + i];
            s[begin + i] = s[end - i - 1];
            s[end - i - 1] = temp;
        }
    }


}
