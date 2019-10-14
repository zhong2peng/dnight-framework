/**
 * @author ZHONGPENG769
 * @date 2019/10/14
 */
public class Solution {

    /**
     * You are playing the following Bulls and Cows game with your friend:
     * You write down a number and ask your friend to guess what the number is.
     * Each time your friend makes a guess, you provide a hint that indicates how many digits in said
     * guess match your secret number exactly in both digit and position (called "bulls")
     * and how many digits match the secret number but locate in the wrong position (called "cows").
     * Your friend will use successive guesses and hints to eventually derive the secret number.
     * <p>
     * Write a function to return a hint according to the secret number and friend's guess,
     * use A to indicate the bulls and B to indicate the cows.
     * <p>
     * Please note that both secret number and friend's guess may contain duplicate digits.
     * <p>
     * Example 1:
     * <p>
     * Input: secret = "1807", guess = "7810"
     * <p>
     * Output: "1A3B"
     * <p>
     * Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
     * Example 2:
     * <p>
     * Input: secret = "1123", guess = "0111"
     * <p>
     * Output: "1A1B"
     * <p>
     * Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
     * <p>
     * 即给出了一个源字符串和一个猜的字符串，长度相等。如果对应位置猜对了，那么这个叫做一个bull；
     * 如果某个位置猜的字符没有猜对，但是这个猜的字符在其他位置出现了，叫做一个cow。统计多少个bull和cow。
     * <p>
     * A表示bulls，B表示cows。
     * 如果bulls中已经出现的数字，就不能再算到cows中了
     *
     * @param secret
     * @param guess
     * @return
     */
    public String getHint(String secret, String guess) {
        char[] sChars = secret.toCharArray();
        char[] gChars = guess.toCharArray();
        int A = 0, B = 0, len = sChars.length;
        for (int i = 0; i < len; i++) {
            if (sChars[i] == gChars[i]) {
                A++;
            } else if (secret.indexOf(gChars[i]) >= 0) {
                B++;
            }
        }
        return A + "A" + B + "B";
    }

    public String getHint1(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                if (numbers[secret.charAt(i) - '0']++ < 0) {
                    cows++;
                }
                if (numbers[guess.charAt(i) - '0']-- > 0) {
                    cows++;
                }
            }
        }
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String hint = solution.getHint1("1123", "0111");
        System.out.println(hint);
    }
}
