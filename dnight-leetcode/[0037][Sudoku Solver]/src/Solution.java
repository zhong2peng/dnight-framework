/**
 * @author ZHONGPENG769
 * @date 2019/6/28
 */
public class Solution {

    /**
     * Write a program to solve a Sudoku puzzle by filling the empty cells.
     * Empty cells are indicated by the character ‘.’.
     * You may assume that there will be only one unique solution.
     *
     * @param board
     */
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        solve(board);
    }

    /**
     * 对于每个需要填数字的格子带入1到9，每代入一个数字都判定其是否合法，
     * 如果合法就继续下一次递归，结束时把数字设回'.'，判断新加入的数字是否合法时，只需要判定当前数字是否合法，
     * 不需要判定这个数组是否为数独数组，因为之前加进的数字都是合法的，这样可以使程序更加高效一些
     *
     * @param board
     * @return
     */
    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == c) {
                return false;
            }
            if (board[row][i] != '.' && board[row][i] == c) {
                return false;
            }
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.' &&
                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }
}
