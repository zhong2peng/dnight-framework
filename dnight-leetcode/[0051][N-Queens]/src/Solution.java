import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/7/2
 */
public class Solution {

    /**
     * The n-queens puzzle is the problem of placing n queens on
     * an n×n chessboard such that no two queens attack each other.
     * <p>
     * Given an integer n, return all distinct solutions to the n-queens puzzle.
     * <p>
     * Each solution contains a distinct board configuration of the n-queens' placement,
     * where 'Q' and '.' both indicate a queen and an empty space respectively.
     * <p>
     * Input: 4
     * Output: [
     * [".Q..",  // Solution 1
     * "...Q",
     * "Q...",
     * "..Q."],
     * <p>
     * ["..Q.",  // Solution 2
     * "Q...",
     * "...Q",
     * ".Q.."]
     * ]
     * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
     *
     * @param n
     * @return
     */
    public List<List<String>> solveNQueues(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n < 1) {
            return result;
        }
        char[][] board = new char[n][];
        for (int i = 0; i < n; i++) {
            board[i] = new char[n];
            Arrays.fill(board[i], '.');
        }
        solveNQueues(board, 0, result);
        return result;
    }

    private void solveNQueues(char[][] board, int row, List<List<String>> result) {
        if (board.length == row) {
            List<String> list = new ArrayList<>();
            for (char[] chs : board) {
                list.add(new String(chs));
            }
            result.add(list);
        }
        for (int col = 0; col < board.length; col++) {
            if (canPlace(board, row, col)) {
                board[row][col] = 'Q';
                solveNQueues(board, row + 1, result);
                board[row][col] = '.';
            }
        }
    }

    private boolean canPlace(char[][] board, int row, int col) {
        //检测之前的列上是否已经放过皇后
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        //45度角(左下角)上是否已经存在过皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; --i, --j) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        //135度角上（左上角）是否已经存在过皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; --i, ++j) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
