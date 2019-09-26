/**
 * @author ZHONGPENG769
 * @date 2019/9/26
 */
public class Solution {

    /**
     * Given two strings s and t, determine if they are isomorphic.
     * <p>
     * Two strings are isomorphic if the characters in s can be replaced to get t.
     * <p>
     * All occurrences of a character must be replaced with another character
     * while preserving the order of characters.
     * No two characters may map to the same character but a character may map to itself.
     * <p>
     * Example 1:
     * <p>
     * Input: s = "egg", t = "add"
     * Output: true
     * Example 2:
     * <p>
     * Input: s = "foo", t = "bar"
     * Output: false
     * Example 3:
     * <p>
     * Input: s = "paper", t = "title"
     * Output: true
     * Note:
     * You may assume both s and t have the same length.
     * <p>
     * 给定两个字符串s和t，判断它们是否是同构的。如果字符串s可以通过字符替换的方式得到字符串t，则称s和t是同构的。
     * 字符的每一次出现都必须被其对应字符所替换，
     * 同时还需要保证原始顺序不发生改变。两个字符不能映射到同一个字符，但是字符可以映射到其本身。
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        // 256个 ascii码
        int[] a = new int[256];
        int[] b = new int[256];
        for (int i = 0; i < 256; i++) {
            a[i] = b[i] = -1;
        }
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (a[s.charAt(i)] != b[t.charAt(i)]) {
                return false;
            }
            // 哈希表，用哈希表记录每一个字符出现的位置，如果对应的字符出现的位置不一样，就返回False，
            // 到最后都一样就返回True。也可以只记录最后一个字符出现的位置，因为之前出现的位置已经比较过了。
            a[s.charAt(i)] = b[t.charAt(i)] = i;
        }
        return true;
    }
}
