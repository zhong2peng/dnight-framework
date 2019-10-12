/**
 * @author ZHONGPENG769
 * @date 2019/10/12
 */
public class Solution {

    /**
     * According to the Wikipedia's article: "The Game of Life, also known simply as Life,
     * is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
     * <p>
     * Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
     * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal)
     * using the following four rules (taken from the above Wikipedia article):
     * <p>
     * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
     * Any live cell with two or three live neighbors lives on to the next generation.
     * Any live cell with more than three live neighbors dies, as if by over-population..
     * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
     * Write a function to compute the next state (after one update) of the board given its current state.
     * The next state is created by applying the above rules simultaneously to every cell in the current state,
     * where births and deaths occur simultaneously.
     * <p>
     * Example:
     * <p>
     * Input:
     * [
     * [0,1,0],
     * [0,0,1],
     * [1,1,1],
     * [0,0,0]
     * ]
     * Output:
     * [
     * [0,0,0],
     * [1,0,1],
     * [0,1,1],
     * [0,1,0]
     * ]
     * <p>
     * 英国数学家发明的生命游戏：使用一个2维数组来实现其规则，在这个数组中，每个存储位子都能容纳一个LIFE元胞。
     * 世代用于标记时间的流逝。每个世代都会LIFE社会带来生与死。生死的规则如下：
     * 1.定义的元胞都有八个邻居。上下左右，左上左下，右上右下八个方位。
     * 2.如果一个元胞有一个或者零个邻居，会因为孤独而死亡。3个以上的邻居会因为拥挤拥挤而死亡
     * 3.如果空元胞正好有3个邻居，会在空元胞的位子生成一个元胞
     * 4.生生死死世代交换
     * <p>
     * 只要有办法区分4种状态,   DEAD->LIVE, DEAD->DEAD, LIVE->LIVE, LIVE->DEAD 即可
     * 0,1, 10, 11 表示
     *
     * @param board
     */
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0] == null
                || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = getLiveNum(board, i, j);
                if (board[i][j] == 0) {
                    if (x == 3) {
                        board[i][j] += 10;
                    }
                } else {
                    if (x == 2 || x == 3) {
                        board[i][j] += 10;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] /= 10;
            }
        }
    }

    private int getLiveNum(int[][] board, int x, int y) {
        int c = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1
                        || (i == x && j == y)) {
                    continue;
                }
                if (board[i][j] % 10 == 1) {
                    c++;
                }
            }
        }
        return c;
    }
}
