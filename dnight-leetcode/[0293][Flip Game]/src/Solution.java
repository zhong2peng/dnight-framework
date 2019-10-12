import java.util.ArrayList;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/10/12
 */
public class Solution {

    /**
     * You are playing the following Flip Game with your friend:
     * Given a string that contains only these two characters: + and -,
     * you and your friend take turns to flip two consecutive "++" into "--".
     * The game ends when a person can no longer make a move and therefore the other person will be the winner.
     * <p>
     * Write a function to compute all possible states of the string after one valid move.
     * <p>
     * For example, given s = "++++", after one move, it may become one of the following states:
     * <p>
     * [
     * "--++",
     * "+--+",
     * "++--"
     * ]
     * If there is no valid move, return an empty list [].
     * <p>
     * 给定字符串中的++换成--，返回所有可能的结果。
     *
     * @param s
     * @return
     */
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
                res.add(s.substring(0, i - 1) + "--" + s.substring(i + 1));
            }
        }
        return res;
    }
}
