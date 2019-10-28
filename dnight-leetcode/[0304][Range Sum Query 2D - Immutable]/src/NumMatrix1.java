/**
 * @author ZHONGPENG769
 * @date 2019/10/28
 */
public class NumMatrix1 {

    private int[][] sum2Origin = null;

    public NumMatrix1(int[][] matrix) {
        if (matrix == null || matrix.length <= 0) {
            return;
        }
        sum2Origin = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                sum2Origin[i][j] = sum2Origin[i][j - 1] + sum2Origin[i - 1][j] - sum2Origin[i - 1][j - 1]
                        + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (sum2Origin == null) {
            return 0;
        }
        return sum2Origin[row2][col2] - sum2Origin[row2][col1] - sum2Origin[row1][col2] + sum2Origin[row1][col1];
    }
}
