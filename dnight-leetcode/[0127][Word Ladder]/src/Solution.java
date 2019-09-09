import java.util.*;

/**
 * @author ZHONGPENG769
 * @date 2019/9/9
 */
public class Solution {

    /**
     * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
     * <p>
     * Only one letter can be changed at a time.
     * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
     * Note:
     * <p>
     * Return 0 if there is no such transformation sequence.
     * All words have the same length.
     * All words contain only lowercase alphabetic characters.
     * You may assume no duplicates in the word list.
     * You may assume beginWord and endWord are non-empty and are not the same.
     * Example 1:
     * <p>
     * Input:
     * beginWord = "hit",
     * endWord = "cog",
     * wordList = ["hot","dot","dog","lot","log","cog"]
     * <p>
     * Output: 5
     * <p>
     * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     * return its length 5.
     * Example 2:
     * <p>
     * Input:
     * beginWord = "hit"
     * endWord = "cog"
     * wordList = ["hot","dot","dog","lot","log"]
     * <p>
     * Output: 0
     * <p>
     * 题目大意：
     * 给定两个词（beginWord和endWord），和一个字典，查找从beginWord转型到endWord的最短长度：
     * - 一次只有一个字母可以被改变
     * - 每个中间字必须存在于词典中
     * <p>
     * 注意：
     * - 如果不存在这样的变换序列，返回0。
     * - 所有单词具有相同的长度。
     * - 所有单词只包含小写字母字符。
     * <p>
     * 解题思路：
     * 广度优化遍历
     * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordDict = new HashSet<>(wordList);
        char[] chars;

        Deque<String> deque = new LinkedList<>();
        deque.addLast(beginWord);

        int result = 0;
        String s;
        String t;

        while (!deque.isEmpty()) {
            for (int k = deque.size(); k > 0; k--) {
                s = deque.removeFirst();
                if (s.equalsIgnoreCase(endWord)) {
                    return result + 1;
                }

                chars = s.toCharArray();
                for (int i = 0; i < beginWord.length(); i++) {
                    for (char j = 'a'; j <= 'z'; j++) {
                        char temp = chars[i];
                        chars[i] = j;
                        t = new String(chars);
                        if (wordDict.contains(t) && !t.equals(s)) {
                            deque.addLast(t);
                            wordDict.remove(t);
                        }
                        chars[i] = temp;
                    }
                }
            }
            result++;
        }
        return 0;

    }
}
