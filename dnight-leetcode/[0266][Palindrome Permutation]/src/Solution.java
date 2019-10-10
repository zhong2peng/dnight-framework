import java.util.HashSet;
import java.util.Set;

/**
 * @author ZHONGPENG769
 * @date 2019/10/10
 */
public class Solution {

    /**
     * Given a string, determine if a permutation of the string could form a palindrome.
     * <p>
     * For example,
     * "code" -> False, "aab" -> True, "carerac" -> True.
     * <p>
     * Hint:
     * <p>
     * Consider the palindromes of odd vs even length. What difference do you notice?
     * Count the frequency of each character.
     * If each character occurs even number of times, then it must be a palindrome.
     * How about character which occurs odd number of times?
     *
     * @param s
     * @return
     */
    public boolean canPermutePalindrome(String s) {
        char[] chars = s.toCharArray();
        //只保留奇数位的字符
        Set<Character> set = new HashSet<>();
        for (Character c : chars) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.size() <= 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canPermutePalindrome("code"));
        System.out.println(solution.canPermutePalindrome("aaaaaab"));
        System.out.println(solution.canPermutePalindrome("carerac"));
    }
}
