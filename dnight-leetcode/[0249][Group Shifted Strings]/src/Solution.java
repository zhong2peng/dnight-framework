import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZHONGPENG769
 * @date 2019/10/8
 */
public class Solution {

    /**
     * Given a string, we can "shift" each of its letter to its successive letter,
     * for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
     * <p>
     * "abc" -> "bcd" -> ... -> "xyz"
     * Given a list of strings which contains only lowercase alphabets,
     * group all strings that belong to the same shifting sequence.
     * <p>
     * Example:
     * <p>
     * Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
     * Output:
     * [
     * ["abc","bcd","xyz"],
     * ["az","ba"],
     * ["acef"],
     * ["a","z"]
     * ]
     * <p>
     * Not Understand yet!!!
     *
     * @param strings
     * @return
     */
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            StringBuffer sb = new StringBuffer();
            for (int i = 1; i < str.length(); i++) {
                int diff = str.charAt(i) - str.charAt(i - 1);
                if (diff < 0) {
                    diff += 26;
                }
                sb.append('a' + diff);
            }
            String key = sb.toString();
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
