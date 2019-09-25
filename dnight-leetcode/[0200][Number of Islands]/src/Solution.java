/**
 * @author ZHONGPENG769
 * @date 2019/9/25
 */
public class Solution {

    char[][] g;

    /**
     * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
     * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
     * You may assume all four edges of the grid are all surrounded by water.
     * <p>
     * Example 1:
     * <p>
     * Input:
     * 11110
     * 11010
     * 11000
     * 00000
     * <p>
     * Output: 1
     * Example 2:
     * <p>
     * Input:
     * 11000
     * 11000
     * 00100
     * 00011
     * <p>
     * Output: 3
     * <p>
     * 有一片水域，四联通的算一个岛，求所有的岛的数目。
     * 我们对每个有“1"的位置进行dfs，把和它四联通的位置全部变成“0”，这样就能把一个点推广到一个岛。
     * Use DFS to find a connected component (an island) and mark all the nodes to 0.
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int islands = 0;
        g = grid;
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                islands += sink(i, j);
            }
        }
        return islands;
    }

    private int sink(int i, int j) {
        if (i < 0 || i == g.length || j < 0 || j == g[i].length || g[i][j] == '0') {
            return 0;
        }
        g[i][j] = '0';
        sink(i + 1, j);
        sink(i - 1, j);
        sink(i, j + 1);
        sink(i, j - 1);
        return 1;
    }

}
