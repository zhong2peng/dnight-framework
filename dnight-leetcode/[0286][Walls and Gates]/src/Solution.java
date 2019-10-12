/**
 * @author ZHONGPENG769
 * @date 2019/10/12
 */
public class Solution {

    /**
     * You are given a m x n 2D grid initialized with these three possible values.
     * <p>
     * -1 - A wall or an obstacle.
     * 0 - A gate.
     * INF - Infinity means an empty room.
     * We use the value 2^31 - 1 = 2147483647 to represent INF as you may assume
     * that the distance to a gate is less than 2147483647.
     * Fill each empty room with the distance to its nearest gate.
     * If it is impossible to reach a gate,
     * it should be filled with INF.
     * <p>
     * For example, given the 2D grid:
     * <p>
     * INF  -1  0  INF
     * INF INF INF  -1
     * INF  -1 INF  -1
     * 0  -1 INF INF
     * After running your function, the 2D grid should be:
     * <p>
     * 3  -1   0   1
     * 2   2   1  -1
     * 1  -1   2  -1
     * 0  -1   3   4
     * <p>
     * 类似一种迷宫问题，规定了-1表示墙，0表示门，让求每个点到门的最近的曼哈顿距离
     *
     * @param rooms
     */
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }

    /**
     * 我们搜索0的位置，每找到一个0，以其周围四个相邻点为起点，开始DFS遍历，并带入深度值1，
     * 如果遇到的值大于当前深度值，我们将位置值赋为当前深度值，
     * 并对当前点的四个相邻点开始DFS遍历，注意此时深度值需要加1，这样遍历完成后，所有的位置就被正确地更新了
     *
     * @param rooms
     * @param i
     * @param j
     * @param d
     */
    private void dfs(int[][] rooms, int i, int j, int d) {
        // <d: return wall+gate+ensure min distance
        if (i < 0 || i >= rooms.length || j >= rooms[0].length || j < 0
                || rooms[i][j] < d) {
            return;
        }
        rooms[i][j] = d;
        dfs(rooms, i - 1, j, d + 1);
        dfs(rooms, i + 1, j, d + 1);
        dfs(rooms, i, j - 1, d + 1);
        dfs(rooms, i, j + 1, d + 1);
    }
}
