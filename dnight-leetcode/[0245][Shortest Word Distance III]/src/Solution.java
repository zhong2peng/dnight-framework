/**
 * @author ZHONGPENG769
 * @date 2019/10/8
 */
public class Solution {

    /**
     * This is a follow up of Shortest Word Distance.
     * The only difference is now word1 could be the same as word2.
     * <p>
     * Given a list of words and two words word1 and word2,
     * return the shortest distance between these two words in the list.
     * <p>
     * word1 and word2 may be the same and they represent two individual words in the list.
     * <p>
     * For example,
     * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
     * <p>
     * Given word1 = “makes”, word2 = “coding”, return 1.
     * Given word1 = "makes", word2 = "makes", return 3.
     * <p>
     * Note:
     * You may assume word1 and word2 are both in the list.
     *
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int distance = Integer.MAX_VALUE;
        if (word1.equals(word2)) {
            int current = -1;
            for (int i = 0; i < words.length; i++) {
                if (word1.equals(words[i])) {
                    if (current == -1) {
                        current = i;
                    } else {
                        distance = Math.min(distance, i - current);
                        current = i;
                    }
                }
            }
        } else {
            int pos1 = -1, pos2 = -1;
            for (int i = 0; i < words.length; i++) {
                if (word1.equals(words[i])) {
                    pos1 = i;
                    if (pos2 != -1) {
                        distance = Math.min(distance, pos1 - pos2);
                    }
                } else if (word2.equals(words[i])) {
                    pos2 = i;
                    if (pos1 != -1) {
                        distance = Math.min(distance, pos2 - pos1);
                    }
                }
            }
        }
        return distance;
    }
}
