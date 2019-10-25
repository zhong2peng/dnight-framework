import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author ZHONGPENG769
 * @date 2019/10/24
 */
public class Solution {

    /**
     * Given a string, find the first non-repeating character in it and return it's index.
     * If it doesn't exist, return -1.
     * <p>
     * Examples:
     * <p>
     * s = "leetcode"
     * return 0.
     * <p>
     * s = "loveleetcode",
     * return 2.
     * <p>
     * 给定一个字符串，请找到第一个未重复出现的字符并返回它的下标，如果没有找到这样的字符，那么久返回 -1
     *
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        if (s == null || s == "") {
            return -1;
        }
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0, len = chars.length; i < len; i++) {
            if (map.containsKey(chars[i])) {
                queue.remove(chars[i]);
                map.put(chars[i], -1);
            } else {
                queue.add(chars[i]);
                map.put(chars[i], i);
            }
        }
        return queue.isEmpty() ? -1 : map.get(queue.peek());

    }

    public static void main(String[] args) {
        int i = new Solution().firstUniqChar("");
        System.out.println(i);

    }
}
