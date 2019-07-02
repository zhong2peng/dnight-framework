/**
 * @author ZHONGPENG769
 * @date 2019/7/2
 */
public class Solution {

    /**
     * <pre>
     * 原题
     * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
     * return the length of last word in the string.
     * If the last word does not exist, return 0.
     * Note: A word is defined as a character sequence consists of non-space characters only.
     * For example,
     * Given s = "Hello World",
     * return 5.
     *
     * 题目大意
     * 给定一个由大小写字母组和空格组成的字符串，返回字符串中的最后一个单词长度。
     *
     * 解题思路
     * 先从后找第一个字母的位置x，如果没有找到就返回0，如果找到，再找第一个空格的位记为y(y可能是-1，
     * 因为没有找到空格)，返回结果x-y。
     * </pre>
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        int index = s.length() - 1;
        while (index >= 0 && s.charAt(index) == ' ') {
            index--;
        }
        if (index < 0) {
            return 0;
        }
        int temp = index;
        while (index >= 0 && s.charAt(index) != ' ') {
            index--;
        }
        return temp - index;

    }
}
