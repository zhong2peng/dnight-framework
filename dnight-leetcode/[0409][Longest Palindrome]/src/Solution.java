import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ZHONGPENG769
 * @date 2019/10/28
 */
public class Solution {

    /**
     * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
     * <p>
     * This is case sensitive, for example "Aa" is not considered a palindrome here.
     * <p>
     * Note:
     * Assume the length of given string will not exceed 1,010.
     * <p>
     * Example:
     * <p>
     * Input:
     * "abccccdd"
     * <p>
     * Output:
     * 7
     * <p>
     * Explanation:
     * One longest palindrome that can be built is "dccaccd", whose length is 7.
     *
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, len = s.length();
        while (i < len) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 0);
            }
            map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            i++;
        }
        int sum = 0;
        for (Integer tmp : map.values()) {
            sum += tmp / 2;
        }
        sum = sum * 2;
        return sum == len ? sum : sum + 1;
    }

    public int longestPalindrome1(String s) {
        if (s == null || s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int count = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (set.remove(c)) {
                count++;
            } else {
                set.add(c);
            }
        }
        return set.isEmpty() ? count * 2 : count * 2 + 1;
    }
}
