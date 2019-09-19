import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ZHONGPENG769
 * @date 2019/9/19
 */
public class Solution {

    /**
     * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
     * for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences
     * within the DNA.
     * <p>
     * Write a function to find all the 10-letter-long sequences (substrings) that occur more than
     * once in a DNA molecule.
     * <p>
     * Example:
     * <p>
     * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
     * <p>
     * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
     * <p>
     * 在一个字符串中找出连续的十个字符，这十个字符不止在一个地方出现过。
     *
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        for (int i = 0; i + 9 < s.length(); i++) {
            String ten = s.substring(i, i + 10);
            if (!seen.add(ten)) {
                repeated.add(ten);
            }
        }
        return new ArrayList<>(repeated);
    }
}
