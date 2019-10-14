import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/10/14
 */
public class Solution {

    /**
     * A group of two or more people wants to meet and minimize the total travel distance.
     * You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group.
     * The distance is calculated usingManhattan Distance,
     * where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
     * <p>
     * For example, given three people living at (0,0), (0,4), and(2,2):
     * <p>
     * 1 - 0 - 0 - 0 - 1
     * |   |   |   |   |
     * 0 - 0 - 0 - 0 - 0
     * |   |   |   |   |
     * 0 - 0 - 1 - 0 - 0
     * The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal.
     * So return 6.
     * <p>
     * 让我们求最佳的开会地点，该地点需要到每个为1的点的曼哈顿距离之和最小
     * 二维的等于一维的相加, 一维的最小点必在median点
     *
     * @param grid
     * @return
     */
    public int minTotalDistance(int[][] grid) {
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    x.add(i);
                    y.add(j);
                }
            }
        }

        return getMP(x) + getMP(y);
    }

    private int getMP(List<Integer> l) {
        Collections.sort(l);
        int i = 0, j = l.size() - 1;
        int res = 0;
        while (i < j) {
            res += l.get(j--) - l.get(i++);
        }
        return res;
    }
}
