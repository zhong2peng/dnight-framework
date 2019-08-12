import java.util.ArrayList;
import java.util.List;

/**
 * Author: dnight
 * Date: 2019/8/12 23:10
 */
public class Solution {

    /**
     * Given a string containing only digits,
     * restore it by returning all possible valid IP address combinations.
     * Input: "25525511135"
     * Output: ["255.255.11.135", "255.255.111.35"]
     *
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        getAns(s, 0, new StringBuilder(), ans, 0);
        return ans;
    }

    /**
     * 那就是分为 4 部分。那么就直接用回溯的思想，
     * 第一部分可能是 1 位数，然后进入递归。
     * 第一部分可能是 2 位数，然后进入递归。
     * 第一部分可能是 3 位数，然后进入递归。
     *
     * @param s
     * @param start
     * @param temp
     * @param ans
     * @param count
     */
    private void getAns(String s, int start, StringBuilder temp, List<String> ans, int count) {
        if (s.length() - start > 3 * (4 - count)) {
            return;
        }
        if (start == s.length()) {
            if (count == 4) {
                ans.add(temp.substring(0, temp.length() - 1));
            }
            return;
        }
        if (start > s.length() || count == 4) {
            return;
        }
        StringBuilder before = new StringBuilder(temp);
        temp.append(s.charAt(start) + '.');
        getAns(s, start + 1, temp, ans, count + 1);

        if (s.charAt(start) == '0') {
            return;
        }
        //加入 2 位数
        if (start + 1 < s.length()) {
            temp = new StringBuilder(before);
            temp.append(s.substring(start, start + 2) + '.');
            getAns(s, start + 2, temp, ans, count + 1);
        }
        //加入 3 位数
        if (start + 2 < s.length()) {
            temp = new StringBuilder(before);
            int num = Integer.parseInt(s.substring(start, start + 3));
            if (num >= 0 && num <= 255) {
                temp.append(s.substring(start, start + 3) + '.');
                getAns(s, start + 3, temp, ans, count + 1);
            }
        }
    }
}
