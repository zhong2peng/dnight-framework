import java.util.*;

/**
 * @author ZHONGPENG769
 * @date 2019/9/9
 */
public class Solution {

    /**
     * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s)
     * from beginWord to endWord, such that:
     * <p>
     * Only one letter can be changed at a time
     * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
     * Note:
     * <p>
     * Return an empty list if there is no such transformation sequence.
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
     * Output:
     * [
     * ["hit","hot","dot","dog","cog"],
     * ["hit","hot","lot","log","cog"]
     * ]
     * Example 2:
     * <p>
     * Input:
     * beginWord = "hit"
     * endWord = "cog"
     * wordList = ["hot","dot","dog","lot","log"]
     * <p>
     * Output: []
     * <p>
     * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
     * 给定两个单词，一个作为开始，一个作为结束，还有一个单词列表。然后依次选择单词，只有当前单词到下一个单词只有
     * 一个字母不同才能被选择，然后新的单词再作为当前单词，直到选到结束的单词。输出这个的最短路径，如果有多组，则都输出。
     * <p>
     * 图的遍历
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordDict = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();
        if (!wordDict.contains(endWord)) {
            return result;
        }

        // 当前待处理的字符串
        Queue<String> q = new LinkedList<>();
        // 处理过的字符串的集合
        Set<String> hs = new HashSet<>();
        // 字母和其顺序
        Map<String, Integer> dist = new HashMap<>();
        q.add(beginWord);
        // 字典中可能用到的字符与可替换的字符串映射关系
        nodeSet.put(beginWord, new ArrayList<>());
        nodeSet.put(endWord, new ArrayList<>());
        dist.put(beginWord, 1);

        while (!q.isEmpty()) {
            String temp = q.poll();
            int l = dist.get(temp);
            hs.add(temp);
            for (int i = 0; i < temp.length(); i++) {
                // 替换temp中每一个位置的字母，遍历字典，看是否存在
                // 替换后的结果（字典中），原始字符串
                for (char c = 'a'; c <= 'z'; c++) {
                    if (temp.charAt(i) == c) {
                        continue;
                    }
                    StringBuilder sb = new StringBuilder(temp);
                    sb.setCharAt(i, c);
                    String next = sb.toString();
                    if (next.equals(endWord)) {
                        // 如果已经遍历到了，则增加
                        if (!dist.containsKey(endWord)) {
                            dist.put(endWord, l + 1);
                            nodeSet.get(endWord).add(temp);
                        } else if (dist.get(endWord) == l + 1) {
                            nodeSet.get(endWord).add(temp);
                        }
                    } else if (wordDict.contains(next) && !hs.contains(next)) {
                        if (!dist.containsKey(next)) {
                            q.add(next);
                            dist.put(next, l + 1);
                            List<String> arr = new ArrayList<>();
                            arr.add(temp);
                            nodeSet.put(next, arr);
                        } else if (dist.get(next) == l + 1) {
                            nodeSet.get(next).add(temp);
                        }
                    }
                }
            }
        }
        List<String> path = new ArrayList<>();
        path.add(endWord);
        collect(beginWord, result, path, nodeSet.get(endWord));
        return result;
    }

    /**
     * 回溯+尾遍历
     *
     * @param beginWord
     * @param result
     * @param path
     * @param preNodes
     */
    private void collect(String beginWord, List<List<String>> result, List<String> path, List<String> preNodes) {
        for (int i = 0; i < preNodes.size(); i++) {
            path.add(0, preNodes.get(i));
            if (preNodes.get(i).equals(beginWord)) {
                List<String> pathCopy = new ArrayList<>(path);
                result.add(pathCopy);
            } else {
                collect(beginWord, result, path, nodeSet.get(preNodes.get(i)));
            }
            path.remove(0);
        }
    }

    Map<String, List<String>> nodeSet = new HashMap<>();

}
