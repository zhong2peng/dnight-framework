import java.util.ArrayList;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/10/10
 */
public class Solution {

    /**
     * Given a string s, return all the palindromic permutations (without duplicates) of it.
     * Return an empty list if no palindromic permutation could be form.
     * <p>
     * For example:
     * <p>
     * Given s = "aabb", return ["abba", "baab"].
     * <p>
     * Given s = "abc", return [].
     * <p>
     * Hint:
     * <p>
     * If a palindromic permutation exists, we just need to generate the first half of the string.
     * To generate all distinct permutations of a (half of) string, use a similar approach from: 
     * Permutations II or Next Permutation
     * <p>
     * Solution:
     * <p>
     * odd time char must be in the middle position, similar with Palindrome Permutation Question,
     * can use int array to store number of char appear time.
     *
     * @param s
     * @return
     */
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[] map = new int[256];
        for (char c : s.toCharArray()) {
            map[c]++;
            min = Math.min(min, c);
            max = Math.max(max, c);
        }
        int count = 0;
        int oddIndex = 0;
        for (int i = min; i <= max; i++) {
            if (count == 0 && map[i] % 2 == 1) {
                oddIndex = i;
                count++;
            } else if (map[i] % 2 == 1) {
                return res;
            }
        }
        String cur = "";
        if (count == 1) {
            cur += (char) oddIndex;
            map[oddIndex]--;
        }
        dfs(map, cur, s, res);
        return res;
    }

    private void dfs(int[] map, String cur, String s, List<String> res) {
        if (cur.length() == s.length()) {
            res.add(cur);
            return;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] > 0) {
                map[i] -= 2;
                cur = (char) i + cur + (char) i;
                dfs(map, cur, s, res);
                cur = cur.substring(1, cur.length() - 1);
                map[i] += 2;
            }
        }
    }
}
