import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZHONGPENG769
 * @date 2019/6/27
 */
public class Solution {

    /**
     * <pre>
     * You are given a string, s, and a list of words, words,
     * that are all of the same length. Find all starting indices
     * of substring(s) in s that is a concatenation of each word
     * in words exactly once and without any intervening characters.
     *
     * For example, given:
     * s: "barfoothefoobarman"
     * words: ["foo", "bar"]
     * You should return the indices: [0,9].
     * (order does not matter).
     * </pre>
     * <p>
     * 解法：
     * 1. 用 HashMap< 单词, 出现次数 > map 来存储所有单词；
     * 2. 设单词数量为 N ，每个单词长度为 len，则我们只需要对比到 **str.length() - N \* len** ,
     * 再往后因为不足 N \* len 个字母，肯定不匹配；
     * 3. 每次从 str 中选取连续的 N \* len 个字母进行匹配时，**从后向前匹配**，因为若后面的单词不匹配，
     * 无论前面的单词是否匹配，当前选取的字串一定不匹配，且，最后一个匹配的单词前的部分一定不在匹配的字串中，
     * 这样下一次选取长度为 N \* len 的字串时，可以**从上次匹配比较中最后一个匹配的单词开始**，减少了比较的次数；
     * 4. 考虑到要点 3 中对前一次匹配结果的利用，遍历 str 时，采用间隔为 len 的形式。
     * 例如示例 1 ，遍历顺序为：(0 3 6 9 12 15) (1 4 7 10 13)(2 5 8 11 14)
     *
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> re = new ArrayList<>();
        if (s == null || words == null || words.length == 0 || words[0] == null) {
            return re;
        }
        if (s.length() == 0 || words[0].length() == 0 || s.length() < words.length * words.length) {
            return re;
        }
        Map<String, Integer> map = new HashMap<>();
        for (String string : words) {
            map.put(string, map.getOrDefault(string, 0) + 1);
        }
        //单词的长度
        int len = words[0].length();
        //字符串的长度
        int strLen = s.length();
        int lastStart = len * words.length - len;

        for (int i = 0; i < len; i++) {
            for (int j = i; j <= strLen - len - lastStart; j += len) {
                String tmpStr = s.substring(j, j + len);
                if (map.containsKey(tmpStr)) {
                    Map<String, Integer> searched = new HashMap<>();
                    //从后向面依次比较
                    int tmpIndex = j + lastStart;
                    String matchedStr = s.substring(tmpIndex, tmpIndex + len);
                    while (tmpIndex >= j && map.containsKey(matchedStr)) {
                        if (searched.getOrDefault(matchedStr, 0) < map.get(matchedStr)) {
                            searched.put(matchedStr, searched.getOrDefault(matchedStr, 0) + 1);
                        } else {
                            break;
                        }
                        tmpIndex -= len;
                        if (tmpIndex < j) {
                            break;
                        }
                        matchedStr = s.substring(tmpIndex, tmpIndex + len);
                    }
                    if (j > tmpIndex) {
                        re.add(j);
                    } else {
                        j = tmpIndex;
                    }
                }
            }
        }
        return re;
    }
}
