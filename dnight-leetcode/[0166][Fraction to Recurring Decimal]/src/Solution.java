import java.util.HashMap;
import java.util.Map;

/**
 * @author ZHONGPENG769
 * @date 2019/9/17
 */
public class Solution {

    /**
     * Given two integers representing the numerator and denominator of a fraction,
     * return the fraction in string format.
     * <p>
     * If the fractional part is repeating, enclose the repeating part in parentheses.
     * <p>
     * Example 1:
     * <p>
     * Input: numerator = 1, denominator = 2
     * Output: "0.5"
     * Example 2:
     * <p>
     * Input: numerator = 2, denominator = 1
     * Output: "2"
     * Example 3:
     * <p>
     * Input: numerator = 2, denominator = 3
     * Output: "0.(6)"
     *
     * @param numerator
     * @param denominator
     * @return
     */
    public String fractionToDecimal(int numerator, int denominator) {
        boolean isNagative = (numerator > 0 && denominator < 0) ||
                (numerator < 0 && denominator > 0);
        long numeratorL = Math.abs((long) numerator);
        long denominatorL = Math.abs((long) denominator);
        Map<Long, Integer> previousRemains = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        long quotian = numeratorL / denominatorL;
        sb.append(quotian);

        numeratorL %= denominatorL;

        if (numeratorL != 0) {
            sb.append(".");
        }

        int quotianIndex = 0;
        while (numeratorL != 0) {
            numeratorL *= 10;
            quotian = Math.abs(numeratorL / denominatorL);
            if (!previousRemains.containsKey(numeratorL)) {
                sb.append(quotian);
                previousRemains.put(numeratorL, quotianIndex++);
            } else {
                int firstIndex = 1 + previousRemains.get(numeratorL) + sb.indexOf(".");
                sb.insert(firstIndex, '(');
                sb.append(")");
                break;
            }
            numeratorL %= denominatorL;
        }
        if (isNagative) {
            sb.insert(0, "-");
        }
        return sb.toString();
    }
}
