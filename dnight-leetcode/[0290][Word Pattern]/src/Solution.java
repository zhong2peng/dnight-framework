import java.util.HashMap;
import java.util.Map;

/**
 * @author ZHONGPENG769
 * @date 2019/10/12
 */
public class Solution {

    /**
     * Given a pattern and a string str, find if str follows the same pattern.
     * <p>
     * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
     * <p>
     * Example 1:
     * <p>
     * Input: pattern = "abba", str = "dog cat cat dog"
     * Output: true
     * Example 2:
     * <p>
     * Input:pattern = "abba", str = "dog cat cat fish"
     * Output: false
     * Example 3:
     * <p>
     * Input: pattern = "aaaa", str = "dog cat cat dog"
     * Output: false
     * Example 4:
     * <p>
     * Input: pattern = "abba", str = "dog dog dog dog"
     * Output: false
     *
     * @param pattern
     * @param str
     * @return
     */
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int i = 0, len = words.length; i < len; i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(words[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(words[i])) {
                    return false;
                }
                map.put(pattern.charAt(i), words[i]);
            }
        }
        return true;
    }
}
