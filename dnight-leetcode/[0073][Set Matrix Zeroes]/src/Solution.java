/**
 * @author ZHONGPENG769
 * @date 2019/7/12
 */
public class Solution {

    /**
     * Given a m x n matrix, if an element is 0,
     * set its entire row and column to 0. Do it in-place.
     * <p>
     * 给定一个矩阵，然后找到所有含有 0 的地方，把该位置所在行所在列的元素全部变成 0
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        boolean rowFlag = false;
        boolean colFlag = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        rowFlag = true;
                    }
                    if (j == 0) {
                        colFlag = true;
                    }

                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (rowFlag) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        if (colFlag) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

    }
}
