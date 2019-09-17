import java.util.HashMap;
import java.util.Map;

/**
 * @author ZHONGPENG769
 * @date 2019/9/17
 */
public class Solution {

    /**
     * Given a string S, find the length of the longest substring T that contains at most two distinct characters.
     * For example,
     * Given S = "eceba",
     * T is "ece" which its length is 3.
     * <p>
     * 给一个字符串，找出最多有两个不同字符的最长子串
     * 滑动窗口法
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        // 起始位置
        int start = 0;
        // 终止位置
        int end = 0;
        // 不同的字符串
        int counter = 0;
        // 最大长度
        int len = 0;
        while (end < s.length()) {
            char cur = s.charAt(end);
            if (!map.containsKey(cur)) {
                map.put(cur, 0);
            }
            map.put(cur, map.get(cur) + 1);
            // new distinct char
            if (map.get(cur) == 1) {
                counter++;
            }
            // when counter > 2, remove one distinct character(till count = 0) to track next substring.
            while (counter > 2) {
                char c2 = s.charAt(start);
                map.put(c2, map.get(c2) - 1);
                // 只有移除一个字符串，counter才会减去1
                if (map.get(c2) == 0) {
                    counter--;
                }
                start++;
            }
            len = Math.max(end - start + 1, len);
            end++;
        }
        return len;
    }
}
