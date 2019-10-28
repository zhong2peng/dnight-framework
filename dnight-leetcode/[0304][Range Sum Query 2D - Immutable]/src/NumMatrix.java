/**
 * @author ZHONGPENG769
 * @date 2019/10/28
 */
public class NumMatrix {
    int[][] matrix;

    /**
     * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined
     * by its upper left corner (row1, col1) and lower right corner (row2, col2).
     */
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}
