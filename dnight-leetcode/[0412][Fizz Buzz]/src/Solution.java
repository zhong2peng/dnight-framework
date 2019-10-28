import java.util.LinkedList;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/10/28
 */
public class Solution {

    /**
     * Write a program that outputs the string representation of numbers from 1 to n.
     * <p>
     * But for multiples of three it should output “Fizz” instead of the number and
     * for the multiples of five output “Buzz”.
     * For numbers which are multiples of both three and five output “FizzBuzz”.
     * <p>
     * Example:
     * <p>
     * n = 15,
     * <p>
     * Return:
     * [
     * "1",
     * "2",
     * "Fizz",
     * "4",
     * "Buzz",
     * "Fizz",
     * "7",
     * "8",
     * "Fizz",
     * "Buzz",
     * "11",
     * "Fizz",
     * "13",
     * "14",
     * "FizzBuzz"
     * ]
     *
     * @param n
     * @return
     */
    public List<String> fizzBuzz(int n) {
        int index = 1;
        List<String> result = new LinkedList<>();
        while (index <= n) {
            if (index % 3 == 0 && index % 5 == 0) {
                result.add("FizzBuzz");
            } else if (index % 3 == 0) {
                result.add("Fizz");
            } else if (index % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(index));
            }
            index++;
        }
        return result;
    }
}
