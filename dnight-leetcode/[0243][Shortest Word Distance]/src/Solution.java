/**
 * @author ZHONGPENG769
 * @date 2019/10/8
 */
public class Solution {

    /**
     * Given a list of words and two words word1 and word2,
     * return the shortest distance between these two words in the list.
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
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    public int shortestDistance(String[] words, String word1, String word2) {
        int i = -1, j = -1;
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < words.length; k++) {
            if (words[k].equals(word1)) {
                if (j != -1 && i == -1) {
                    min = k - j;
                } else {
                    min = Math.min(min, k - j);
                }
                i = k;
            } else if (words[k].equals(word2)) {
                if (i != -1 && j == -1) {
                    min = k - i;
                } else {
                    min = Math.min(min, k - i);
                }
                j = k;
            }
        }
        return min;
    }
}
