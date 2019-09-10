import java.util.*;

/**
 * @author ZHONGPENG769
 * @date 2019/9/10
 */
public class Solution {

    /**
     * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
     * add spaces in s to construct a sentence where each word is a valid dictionary word.
     * Return all such possible sentences.
     * <p>
     * Note:
     * <p>
     * The same word in the dictionary may be reused multiple times in the segmentation.
     * You may assume the dictionary does not contain duplicate words.
     * Example 1:
     * <p>
     * Input:
     * s = "catsanddog"
     * wordDict = ["cat", "cats", "and", "sand", "dog"]
     * Output:
     * [
     * "cats and dog",
     * "cat sand dog"
     * ]
     *
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        Map<Integer, List<String>> cache = new HashMap<>();
        return rec(s, 0, words, cache);
    }

    private List<String> rec(String s, int idx, Set<String> words, Map<Integer, List<String>> cache) {
        List<String> res = cache.get(idx);
        if (res != null) {
            return res;
        }
        res = new ArrayList<>();
        for (int i = idx; i < s.length(); i++) {
            String cand = s.substring(idx, i + 1);
            if (words.contains(cand)) {
                if (i == s.length() - 1) {
                    res.add(cand);
                } else {
                    List<String> sub = rec(s, i + 1, words, cache);
                    for (String item : sub) {
                        res.add(cand + " " + item);
                    }
                }
            }
        }
        cache.put(idx, res);
        return res;
    }
}
