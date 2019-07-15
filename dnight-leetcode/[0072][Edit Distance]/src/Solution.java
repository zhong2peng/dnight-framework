/**
 * @author ZHONGPENG769
 * @date 2019/7/12
 */
public class Solution {

    /**
     * Given two words word1 and word2, find the minimum number of operations
     * required to convert word1 to word2.
     * <p>
     * You have the following 3 operations permitted on a word:
     * <p>
     * Insert a character
     * Delete a character
     * Replace a character
     * <p>
     * 由一个字符串变为另一个字符串的最少操作次数，可以删除一个字符，替换一个字符，插入一个字符，
     * 也叫做最小编辑距离。
     * <p>
     * 递归
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0 && word2.length() == 0) {
            return 0;
        }
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }
        int x = minDistance(word1, word2.substring(0, word2.length() - 1)) + 1;
        int y = minDistance(word1.substring(0, word1.length() - 1), word2) + 1;
        int z = minDistance(word1.substring(0, word1.length() - 1),
                word2.substring(0, word2.length() - 1));
        if (word1.charAt(word1.length() - 1) != word2.charAt(word2.length() - 1)) {
            z++;
        }
        return Math.min(Math.min(x, y), z);
    }

    /**
     * 动态规划
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance1(String word1, String word2) {
        if (word1.length() == 0 && word2.length() == 0) {
            return 0;
        }
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }
        int[][] ans = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            ans[i][0] = i;
        }
        for (int i = 0; i < word2.length(); i++) {
            ans[0][i] = i;
        }
        int n1 = word1.length();
        int n2 = word2.length();
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                int min_delete = Math.min(ans[i - 1][j], ans[i][j - 1]) + 1;
                int replace = ans[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    replace++;
                }
                ans[i][j] = Math.min(min_delete, replace);
            }
        }
        return ans[n1][n2];
    }
}
