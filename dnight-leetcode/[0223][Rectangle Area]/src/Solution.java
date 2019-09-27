/**
 * @author ZHONGPENG769
 * @date 2019/9/27
 */
public class Solution {

    /**
     * Find the total area covered by two rectilinear rectangles in a 2D plane.
     * <p>
     * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
     * <p>
     * Example:
     * <p>
     * Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
     * Output: 45
     * Note:
     * <p>
     * Assume that the total area is never beyond the maximum possible value of int.
     * <p>
     * 找到在二维平面中两个相交矩形的总面积。
     * 每个矩形都定义了其左下角和右上角的坐标。
     *
     * @param A
     * @param B
     * @param C
     * @param D
     * @param E
     * @param F
     * @param G
     * @param H
     * @return
     */
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int areaOfSqrtA = (C - A) * (D - B);
        int areaOfSqrtB = (G - E) * (H - F);
        int left = Math.max(A, E);
        int right = Math.min(G, C);
        int bottom = Math.max(F, B);
        int top = Math.min(D, H);

        int overlap = 0;
        if (right > left && top > bottom) {
            overlap = (right - left) * (top - bottom);
        }
        return areaOfSqrtA + areaOfSqrtB - overlap;
    }
}
