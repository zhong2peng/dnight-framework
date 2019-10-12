/**
 * @author ZHONGPENG769
 * @date 2019/10/12
 */
public class Solution {

    /**
     * You are playing the following Flip Game with your friend:
     * Given a string that contains only these two characters: + and -,
     * you and your friend take turns to flip two consecutive "++" into "--".
     * The game ends when a person can no longer make a move and
     * therefore the other person will be the winner.
     * <p>
     * Write a function to determine if the starting player can guarantee a win.
     * <p>
     * For example, given s = "++++", return true.
     * The starting player can guarantee a win by flipping the middle "++" to become "+--+".
     * <p>
     * Follow up:
     * Derive your algorithm's runtime complexity.
     *
     * @param s
     * @return
     */
    public boolean canWin(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                StringBuilder sb = new StringBuilder(s);
                sb.setCharAt(i, '-');
                sb.setCharAt(i + 1, '-');
                if (!canWin(sb.toString())) {
                    return true;
                }
            }
        }
        return false;
    }
}
