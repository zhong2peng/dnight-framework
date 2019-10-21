import java.util.HashMap;
import java.util.Map;

/**
 * @author ZHONGPENG769
 * @date 2019/10/18
 */
public class Solution {

    /**
     * Given an arbitrary ransom note string and another string containing letters from all the magazines,
     * write a function that will return true if the ransom note can be constructed from the magazines ;
     * otherwise, it will return false.
     * <p>
     * Each letter in the magazine string can only be used once in your ransom note.
     * <p>
     * Note:
     * You may assume that both strings contain only lowercase letters.
     * <p>
     * canConstruct("a", "b") -> false
     * canConstruct("aa", "ab") -> false
     * canConstruct("aa", "aab") -> true
     * <p>
     * 勒索信，为了不暴露字迹，就从杂志上搜索各个需要的字母，组成单词来表达的意思
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine == null) {
            return false;
        }
        if (ransomNote == null) {
            return true;
        }
        char[] chars1 = ransomNote.toCharArray();
        char[] chars2 = magazine.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, len = chars1.length; i < len; i++) {
            if (!map.containsKey(chars1[i])) {
                map.put(chars1[i], 0);
            }
            map.put(chars1[i], map.get(chars1[i]) + 1);
        }
        for (int i = 0, len = chars2.length; i < len; i++) {
            if (map.containsKey(chars2[i])) {
                if (map.get(chars2[i]) == 1) {
                    map.remove(chars2[i]);
                } else {
                    map.put(chars2[i], map.get(chars2[i]) - 1);
                }
            }
        }
        return map.size() == 0;
    }

    public boolean canConstruct1(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        if (ransomNote.isEmpty() && magazine.isEmpty()) return true;
        Map<Character, Integer> charsCount = new HashMap<>();
        for (char c : ransomNote.toCharArray()) {
            if (charsCount.containsKey(c)) {
                charsCount.put(c, charsCount.get(c) + 1);
            } else {
                charsCount.put(c, 1);
            }
        }
        for (char c : magazine.toCharArray()) {
            if (charsCount.containsKey(c)) {
                int count = charsCount.get(c);
                if (--count == 0) charsCount.remove(c);
                else charsCount.put(c, count);
            }
            if (charsCount.keySet().size() == 0) {
                return true;
            }
        }
        return false;
    }
}
