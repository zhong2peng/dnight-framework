import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZHONGPENG769
 * @date 2019/10/8
 */
public class WordDistance {

    Map<String, List<Integer>> maps;

    public WordDistance(String[] words) {
        maps = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!maps.containsKey(word)) {
                maps.put(word, new ArrayList<>());
            }
            maps.get(word).add(i);
        }
    }

    /**
     * This is a follow up of Shortest Word Distance.
     * The only difference is now you are given the list of words and your method will be called
     * repeatedly many times with different parameters. How would you optimize it?
     * <p>
     * Design a class which receives a list of words in the constructor,
     * and implements a method that takes two words word1 and word2
     * and return the shortest distance between these two words in the list.
     * <p>
     * For example,
     * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
     * <p>
     * Given word1 = “coding”, word2 = “practice”, return 3.
     * Given word1 = "makes", word2 = "coding", return 1.
     * <p>
     * Note:
     * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
     *
     * @param word1
     * @param word2
     * @return
     */
    public int shortest(String word1, String word2) {
        List<Integer> l1 = maps.get(word1);
        List<Integer> l2 = maps.get(word2);
        int i = 0, j = 0;
        int minDist = Integer.MAX_VALUE;
        while (i < l1.size() && j < l2.size()) {
            int idx1 = l1.get(i);
            int idx2 = l2.get(j);
            if (idx1 < idx2) {
                minDist = Math.min(minDist, idx2 - idx1);
                i++;
            } else {
                minDist = Math.min(minDist, idx1 - idx2);
                j++;
            }
        }
        return minDist;
    }
}
