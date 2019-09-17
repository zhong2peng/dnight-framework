/**
 * @author ZHONGPENG769
 * @date 2019/9/16
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Point[] points = new Point[3];
        points[0] = new Point(1, 1);
        points[1] = new Point(2, 2);
        points[2] = new Point(3, 3);
        int i = solution.maxPoints(points);
        System.out.println(i);

        Point[] points1 = new Point[6];
        points1[0] = new Point(1, 1);
        points1[1] = new Point(3, 2);
        points1[2] = new Point(5, 3);
        points1[3] = new Point(4, 1);
        points1[4] = new Point(2, 3);
        points1[5] = new Point(1, 4);
        int i1 = solution.maxPoints(points1);
        System.out.println(i1);
    }
}
