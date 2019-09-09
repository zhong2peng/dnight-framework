/**
 * @author ZHONGPENG769
 * @date 2019/9/9
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {
                "XXXX".toCharArray(),
                "XOOX".toCharArray(),
                "XXOX".toCharArray(),
                "XOXX".toCharArray()
        };
        solution.solve(board);
        for (char[] line : board) {
            System.out.println(new String(line));
        }
    }
}
