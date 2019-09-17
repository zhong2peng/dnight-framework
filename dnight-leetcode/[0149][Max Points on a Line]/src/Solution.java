/**
 * @author ZHONGPENG769
 * @date 2019/9/16
 */
public class Solution {

    /**
     * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
     * <p>
     * Example 1:
     * <p>
     * Input: [[1,1],[2,2],[3,3]]
     * Output: 3
     * Explanation:
     * ^
     * |
     * |        o
     * |     o
     * |  o
     * +------------->
     * 0  1  2  3  4
     * Example 2:
     * <p>
     * Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
     * Output: 4
     * Explanation:
     * ^
     * |
     * |  o
     * |     o        o
     * |        o
     * |  o        o
     * +------------------->
     * 0  1  2  3  4  5  6
     * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
     *
     * @param points
     * @return
     */
    public int maxPoints(Point[] points) {
        if (points == null) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }
        int max = 2;
        for (int i = 0; i < points.length; i++) {
            int samePosition = 0;
            int sameSlope = 1;
            for (int j = i + 1; j < points.length; j++) {
                long x1 = points[j].x - points[i].x;
                long y1 = points[j].y - points[i].y;
                if (x1 == 0 && y1 == 0) {
                    samePosition++;
                } else {
                    sameSlope++;
                    for (int k = j + 1; k < points.length; k++) {
                        long x2 = points[k].x - points[i].x;
                        long y2 = points[k].y - points[i].y;
                        if (x1 * y2 == x2 * y1) {
                            sameSlope++;
                        }
                    }
                }
                if (max < (samePosition + sameSlope)) {
                    max = samePosition + sameSlope;
                }
                sameSlope = 1;
            }
        }
        return max;
    }
}
