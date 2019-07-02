import java.util.Arrays;

/**
 * @author ZHONGPENG769
 * @date 2019/7/2
 */
public class Solution {

    /**
     * The n-queens puzzle is the problem of placing n queens
     * on an n×n chessboard such that no two queens attack each other.
     * <p>
     * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
     * <p>
     * Example:
     * <p>
     * Input: 4
     * Output: 2
     * Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
     * [
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
     *
     * @param n
     * @return
     */
    public int totalNQueues(int n) {
        int[] result = {0};
        if (n < 1) {
            return result[0];
        }
        char[][] board = new char[n][];
        for (int i = 0; i < n; i++) {
            board[i] = new char[n];
            Arrays.fill(board[i], '.');
        }
        solveNQueues(board, 0, result);
        return result[0];
    }

    private void solveNQueues(char[][] board, int row, int[] result) {
        if (board.length == row) {
            result[0]++;
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
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
