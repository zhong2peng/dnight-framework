import java.util.*;

/**
 * @author ZHONGPENG769
 * @date 2019/10/10
 */
public class Solution {

    /**
     * There is a new alien language which uses the latin alphabet.
     * However, the order among letters are unknown to you.
     * You receive a list of words from the dictionary,
     * where words are sorted lexicographically by the rules of this new language.
     * Derive the order of letters in this language.
     * <p>
     * For example,
     * Given the following words in dictionary,
     * [
     *   "wrt",
     *   "wrf",
     *   "er",
     *   "ett",
     *   "rftt"
     * ]
     * The correct order is: "wertf".
     * <p>
     * Note:
     * You may assume all letters are in lowercase.
     * If the order is invalid, return an empty string.
     * There may be multiple valid order of letters, return any one of them is fine.
     * <p>
     * 给一个单词字典，单词是按照字典序排序，求字母的排序。跟每个Word里面的letter顺序并没有什么关系
     * 在图论中，拓扑排序（Topological Sorting）是一个有向无环图（DAG, Directed Acyclic Graph）的所有顶点的线性序列。
     * 拓扑排序通常用来“排序”具有依赖关系的任务。
     * <p>
     * 该序列必须满足下面两个条件：
     * 1）每个顶点出现且只出现一次。
     * 2）若存在一条从顶点 A 到顶点 B 的路径，那么在序列中顶点 A 出现在顶点 B 的前面。
     * <p>
     * 如何写出它的拓扑排序呢？这里说一种比较常用的方法：
     * <p>
     * 从 DAG 图中选择一个没有前驱（即入度为0）的顶点并输出。
     * 从图中删除该顶点和所有以它为起点的有向边。
     * 重复 1 和 2 直到当前的 DAG 图为空或当前图中不存在无前驱的顶点为止。
     * 后一种情况说明有向图中必然存在环。
     * <p>
     * 拓扑排序通常用来“排序”具有依赖关系的任务。
     * <p>
     * 比如，如果用一个DAG图来表示一个工程，其中每个顶点表示工程中的一个任务，
     * 用有向边<A,B><A,B>表示在做任务 B 之前必须先完成任务 A。
     * 故在这个工程中，任意两个任务要么具有确定的先后关系，要么是没有关系，绝对不存在互相矛盾的关系
     *
     * @param words
     * @return
     */
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        Map<Character, Set<Character>> graph = new HashMap<>();
        // 存储出现的所有字符
        Set<Character> set = new HashSet<>();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                set.add(word.charAt(i));
            }
        }
        // 入度
        int[] inDegree = new int[26];
        for (int k = 1; k < words.length; k++) {
            String preStr = words[k - 1];
            String curStr = words[k];
            for (int i = 0; i < Math.min(preStr.length(), curStr.length()); i++) {
                char preChar = preStr.charAt(i);
                char curChar = curStr.charAt(i);
                if (preChar != curChar) {
                    if (!graph.containsKey(preChar)) {
                        graph.put(preChar, new HashSet<>());
                    }
                    if (!graph.get(preChar).contains(curChar)) {
                        inDegree[curChar - 'a']++;
                    }
                    graph.get(preChar).add(curChar);
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                char c = (char) ('a' + i);
                if (set.contains(c)) {
                    queue.offer(c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            if (graph.containsKey(c)) {
                for (char l : graph.get(c)) {
                    inDegree[l - 'a']--;
                    if (inDegree[l - 'a'] == 0) {
                        queue.offer(l);
                    }
                }
            }
        }
        return sb.length() != set.size() ? "" : sb.toString();
    }
}
