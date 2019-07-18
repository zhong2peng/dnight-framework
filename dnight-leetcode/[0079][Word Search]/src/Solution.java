/**
 * @author ZHONGPENG769
 * @date 2019/7/15
 */
public class Solution {

    /**
     * <pre>
     * Given a 2D board and a word, find if the word exists in the grid.
     *
     * The word can be constructed from letters of sequentially adjacent cell,
     * where "adjacent" cells are those horizontally or vertically neighboring.
     * The same letter cell may not be used more than once.
     *
     * For example,
     * Given board =
     * [
     *      ["ABCE"],
     *      ["SFCS"],
     *      ["ADEE"]
     * ]
     * word = "ABCCED", -> returns true,
     * word = "SEE", -> returns true,
     * word = "ABCB", -> returns false.
     *
     * 题目大意：
     * 给定一个board字符矩阵，可以从任意一个点开始经过上下左右的方式走，每个点只能走一次，
     * 如果存在一条路走过的字符等于给定的字符串，那么返回true
     *
     * 解题思路：
     * 以每一个点作为起点，使用回溯法进行搜索
     * </pre>
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board, visited, i, j, word, new int[]{0})) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, boolean[][] visited, int row, int col, String word, int[] idx) {
        if (idx[0] == word.length()) {
            return true;
        }
        boolean hasPath = false;
        if (check(board, visited, row, col, word, idx[0])) {
            visited[row][col] = true;
            idx[0]++;
            hasPath = search(board, visited, row - 1, col, word, idx)
                    || search(board, visited, row, col - 1, word, idx)
                    || search(board, visited, row + 1, col, word, idx)
                    || search(board, visited, row, col + 1, word, idx);
            if (!hasPath) {
                visited[row][col] = false;
                idx[0]--;
            }
        }
        return hasPath;
    }

    private boolean check(char[][] board, boolean[][] visited, int row, int col, String word, int idx) {
        return row >= 0 && row < board.length && col >= 0
                && col < board[0].length &&
                !visited[row][col]
                && board[row][col] == word.charAt(idx);
    }
}
