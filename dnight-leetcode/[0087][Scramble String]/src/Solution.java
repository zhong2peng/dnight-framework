/**
 * @author ZHONGPENG769
 * @date 2019/8/1
 */
public class Solution {

    /**
     * 把一个字符串按照树的形状，分成两部分，分成两部分...直到达到叶子节点。并且可以多次交换非叶子节点的两个子树，
     * 最后从左到右读取叶子节点，记为生成的字符串。题目是给两个字符串 S1 和 S2，然后问 S2 是否是 S1 经过上述方式生成的
     * <p>
     * 递归 or 动态规划
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        int[] letters = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) {
                return false;
            }
        }

        int length = s1.length();
        boolean[][][] dp = new boolean[length + 1][length][length];
        //遍历所有的字符串长度
        for (int len = 1; len <= length; len++) {
            //S1 开始的地方
            for (int i = 0; i + len <= length; i++) {
                //S2 开始的地方
                for (int j = 0; j + len <= length; j++) {
                    //长度是 1 无需切割
                    if (len == 1) {
                        dp[len][i][j] = s1.charAt(i) == s2.charAt(j);
                    } else {
                        //遍历切割后的左半部分长度
                        for (int q = 1; q < len; q++) {
                            dp[len][i][j] = dp[q][i][j] && dp[len - q][i + q][j + q]
                                    || dp[q][i][j + len - q] && dp[len - q][i + q][j];
                            //如果当前是 true 就 break，防止被覆盖为 false
                            if (dp[len][i][j]) {
                                break;
                            }
                        }
                    }
                }
            }
        }
        return dp[length][0][0];
    }
}
