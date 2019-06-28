import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ZHONGPENG769
 * @date 2019/6/28
 */
public class Solution {

    /**
     * <pre>
     * 原题
     * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
     * The Sudoku board could be partially filled, where empty cells are filled
     * with the character '.'.
     *
     * A partially filled sudoku which is valid.
     * Note:
     * A valid Sudoku board (partially filled) is not necessarily solvable.
     * Only the filled cells need to be validated.
     *
     * 题目大意
     * 验证一个数独棋盘是否合法，数独棋盘的验证规则见链接对应的页面。
     * 数独棋盘是部分填满的，空的位置使用点来代替。
     * 注意：合法的棋盘不一定要求的可解的，只要填充的数字满足要求就可以。
     *
     * 解题思路
     * 先对行进行检查，再对列进行检查，最后检查３*３的方格。
     * </pre>
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        int number = board[0].length;
        int[] record = new int[10 + 2];
        reset(record);
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                record[board[i][j] - '.']++;
            }
            if (!check(record)) {
                return false;
            } else {
                reset(record);
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = i * 3; k < (i + 1) * 3; k++) {
                    for (int l = j * 3; l < (j + 1) * 3; l++) {
                        record[board[k][l] - '.']++;
                    }
                }
                if (!check(record)) {
                    return false;
                } else {
                    reset(record);
                }
            }
        }
        return true;
    }

    public void reset(int[] a) {
        Arrays.fill(a, 0);
    }

    public boolean check(int[] a) {
        for (int i = 2; i < a.length; i++) {
            if (a[i] > 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 每一行必须是数字1~9且不重复
     * 每一列必须是数字1~9且不重复
     * 每一个小九宫格（互不交叉，总共九个小九宫格）必须是数字1~9且不重复
     * <p>
     * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
     * Only the filled cells need to be validated according to the mentioned rules.
     * The given board contain only digits 1-9 and the character ‘.’.
     * The given board size is always 9x9.
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku1(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> col = new HashSet<>(), row = new HashSet<>(), cube = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !row.add(board[i][j]))
                    return false;
                if (board[j][i] != '.' && !col.add(board[j][i]))
                    return false;
                int colIndex = i / 3 * 3 + j / 3, rowIndex = i % 3 * 3 + j % 3;
                if (board[rowIndex][colIndex] != '.' && !cube.add(board[rowIndex][colIndex]))
                    return false;
            }
        }
        return true;
    }


}
