import java.util.*;

/**
 * @author ZHONGPENG769
 * @date 2019/9/27
 */
public class Solution {

    /**
     * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance.
     * Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A),
     * write a program to output the skyline formed by these buildings collectively (Figure B).
     * <p>
     * Buildings Skyline Contour
     * The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi],
     * where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively,
     * and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0.
     * You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
     * <p>
     * For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12],
     * [15 20 10], [19 24 8] ] .
     * <p>
     * The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2],
     * [x3, y3], ... ] that uniquely defines a skyline. A key point is the left endpoint of a horizontal
     * line segment. Note that the last key point, where the rightmost building ends, is merely used to mark
     * the termination of the skyline, and always has zero height. Also, the ground in between any two
     * adjacent buildings should be considered part of the skyline contour.
     * <p>
     * For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0],
     * [15 10], [20 8], [24, 0] ].
     * <p>
     * Notes:
     * <p>
     * The number of buildings in any input list is guaranteed to be in the range [0, 10000].
     * The input list is already sorted in ascending order by the left x position Li.
     * The output list must be sorted by the x position.
     * There must be no consecutive horizontal lines of equal height in the output skyline. For instance,
     * [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be
     * merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
     * <p>
     * 城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。现在，假设您获得了城市风光照片（图A）上显示的所有建筑物的位置和高度，
     * 请编写一个程序以输出由这些建筑物形成的天际线（图B）。
     *
     * @param buildings
     * @return
     */
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for (int[] b : buildings) {
            // [left, right, height]
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        Collections.sort(height, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        Queue<Integer> pg = new PriorityQueue<>((a, b) -> (b - a));
        pg.offer(0);
        int prev = 0;
        for (int[] h : height) {
            if (h[1] < 0) {
                pg.offer(-h[1]);
            } else {
                pg.remove(h[1]);
            }
            int cur = pg.peek();
            if (prev != cur) {
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return result;

    }
}
