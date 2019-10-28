/**
 * @author ZHONGPENG769
 * @date 2019/10/28
 */
public class Solution {

    /**
     * Given a non-empty string s and an abbreviation abbr,
     * return whether the string matches with the given abbreviation.
     * <p>
     * A string such as "word" contains only the following valid abbreviations:
     * <p>
     * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2",
     * "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
     * Notice that only the above abbreviations are valid abbreviations of the string "word".
     * Any other string is not a valid abbreviation of "word".
     * <p>
     * Note:
     * Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.
     * <p>
     * Example 1:
     * <p>
     * Given s = "internationalization", abbr = "i12iz4n":
     * <p>
     * Return true.
     * Example 2:
     * <p>
     * Given s = "apple", abbr = "a2e":
     * <p>
     * Return false.
     *
     * @param word
     * @param abbr
     * @return
     */
    Boolean validWordAbbreviation(String word, String abbr) {
        int k = 0, i = 0, len1 = word.length(), len2 = abbr.length();
        if (len2 > len1) {
            return false;
        }
        while (i < len2) {
            if (word.charAt(k) == abbr.charAt(i)) {
                i++;
                k++;
                continue;
            }
            int cnt = 0;
            if (abbr.charAt(i) == '0') {
                return false;
            }
            while (i < len2 && Character.isDigit(abbr.charAt(i))) {
                cnt = cnt * 10 + (abbr.charAt(i) - '0');
                i++;
            }
            k += cnt;
            if (k > len1 || (k < len1 && i < len2 && word.charAt(k) != abbr.charAt(i))) {
                return false;
            }
        }
        return k == len1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Boolean aBoolean = solution.validWordAbbreviation("apple", "a2e");
        System.out.println(aBoolean);

    }
}
