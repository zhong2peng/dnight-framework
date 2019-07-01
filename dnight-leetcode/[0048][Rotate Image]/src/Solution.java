/**
 * @author ZHONGPENG769
 * @date 2019/7/1
 */
public class Solution {

    /**
     * You are given an n x n 2D matrix representing an image.
     * Rotate the image by 90 degrees (clockwise).
     * <p>
     * Note:
     * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
     * DO NOT allocate another 2D matrix and do the rotation.
     * <p>
     * Given input matrix =
     * [
     * [1,2,3],
     * [4,5,6],
     * [7,8,9]
     * ],
     * <p>
     * rotate the input matrix in-place such that it becomes:
     * [
     * [7,4,1],
     * [8,5,2],
     * [9,6,3]
     * ]
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int temp;
        //先做y=x对称转换
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //再对行进行垂直转换
        int half = matrix.length / 2;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < half; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
}
