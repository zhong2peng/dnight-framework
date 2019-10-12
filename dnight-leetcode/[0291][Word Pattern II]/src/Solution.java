import java.util.HashMap;
import java.util.Map;

/**
 * @author ZHONGPENG769
 * @date 2019/10/12
 */
public class Solution {

    /**
     * Given a pattern and a string str, find if strfollows the same pattern.
     * <p>
     * Here follow means a full match, such that there is a bijection between a letter
     * in pattern and a non-empty substring in str.
     * <p>
     * Example 1:
     * <p>
     * Input: pattern = "abab", str = "redblueredblue"
     * Output: true
     * Example 2:
     * <p>
     * Input: pattern = pattern = "aaaa", str = "asdasdasdasd"
     * Output: true
     * Example 3:
     * <p>
     * Input: pattern = "aabb", str = "xyzabcxzyabc"
     * Output: false
     * Notes:
     * You may assume both pattern and str contains only lowercase letters.
     *
     * @param pattern
     * @param str
     * @return
     */
    Boolean wordPatternMatch(String pattern, String str) {
        if (pattern == null || str == null || str.length() < pattern.length()) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        return helper(pattern, 0, str, 0, map);
    }

    private Boolean helper(String pattern, int i, String str, int j, Map<Character, String> map) {
        if (i == pattern.length() && j == str.length()) {
            return true;
        }
        if (i == pattern.length() || j == str.length()) {
            return false;
        }
        char ch = pattern.charAt(i);
        if (map.containsKey(ch)) {
            String s = map.get(ch);
            if (!str.substring(j).startsWith(s)) {
                return false;
            } else {
                return helper(pattern, i + 1, str, j + s.length(), map);
            }
        } else {
            for (int k = j; k < str.length(); k++) {
                String part = str.substring(j, k + 1);
                if (map.containsValue(part)) {
                    continue;
                }
                // backtracking
                map.put(ch, part);
                if (helper(pattern, i + 1, str, k + 1, map)) {
                    return true;
                }
                map.remove(ch);
            }
        }
        return false;
    }


}
