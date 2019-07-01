import java.util.*;

/**
 * @author ZHONGPENG769
 * @date 2019/7/1
 */
public class Solution {

    /**
     * Given an array of strings, group anagrams together.
     * <p>
     * Example:
     * <p>
     * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * Output:
     * [
     * ["ate","eat","tea"],
     * ["nat","tan"],
     * ["bat"]
     * ]
     * Note:
     * <p>
     * All inputs will be in lowercase.
     * The order of your output does not matter.
     * <p>
     * 算法原理：对字符串进行排序，相同类型的字符串排序后的字符串都是一样的
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAngrams1(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List> ans = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    /**
     * 算法原理：统计每个字符出现的次数，然后使用#字符将每个字符出现的次数拼成一个字符串，
     * 相同类型的字符串通过上面的方式拼出来的字符串都是一样的
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAngrams2(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List> ans = new HashMap<>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}
