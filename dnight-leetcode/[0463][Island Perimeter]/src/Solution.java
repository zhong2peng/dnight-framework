/**
 * @author ZHONGPENG769
 * @date 2019/11/17
 */
public class Solution {

    /**
     * You are given a map in form of a two-dimensional integer grid
     * where 1 represents land and 0 represents water.
     * <p>
     * Grid cells are connected horizontally/vertically (not diagonally).
     * The grid is completely surrounded by water, and there is exactly one island
     * (i.e., one or more connected land cells).
     * <p>
     * The island doesn't have "lakes" (water inside that isn't connected to the water around the island).
     * One cell is a square with side length 1.
     * The grid is rectangular, width and height don't exceed 100.
     * Determine the perimeter of the island.
     * <p>
     * <p>
     * <p>
     * Example:
     * <p>
     * Input:
     * [[0,1,0,0],
     * [1,1,1,0],
     * [0,1,0,0],
     * [1,1,0,0]]
     * <p>
     * Output: 16
     *
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int res = 0, col = grid.length, row = grid[0].length;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (grid[i][j] == 1) {
                    if (i < 1 || grid[i - 1][j] == 0) {
                        res++;
                    }
                    if (i == col - 1 || grid[i + 1][j] == 0) {
                        res++;
                    }
                    if (j < 1 || grid[i][j - 1] == 0) {
                        res++;
                    }
                    if (j == row - 1 || grid[i][j + 1] == 0) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
