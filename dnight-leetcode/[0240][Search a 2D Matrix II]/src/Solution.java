/**
 * @author ZHONGPENG769
 * @date 2019/9/29
 */
public class Solution {

    /**
     * Write an efficient algorithm that searches for a value in an m x n matrix.
     * This matrix has the following properties:
     * <p>
     * Integers in each row are sorted in ascending from left to right.
     * Integers in each column are sorted in ascending from top to bottom.
     * Example:
     * <p>
     * Consider the following matrix:
     * <p>
     * [
     * [1,   4,  7, 11, 15],
     * [2,   5,  8, 12, 19],
     * [3,   6,  9, 16, 22],
     * [10, 13, 14, 17, 24],
     * [18, 21, 23, 26, 30]
     * ]
     * Given target = 5, return true.
     * <p>
     * Given target = 20, return false.
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;

        int right = cols - 1;
        int bottom = 0;
        while (bottom < rows && right < cols && right >= 0 && matrix[bottom][right] != target) {
            boolean flag = false;
            while (bottom < rows && matrix[bottom][right] < target) {
                bottom++;
                flag = true;
            }
            while (right >= 0 && bottom < rows && matrix[bottom][right] > target) {
                right--;
                flag = true;
            }
            if (!flag) {
                break;
            }
        }
        if (right >= 0 && bottom < rows) {
            return matrix[bottom][right] == target;
        } else {
            return false;
        }


    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while (col >= 0 && row <= matrix.length - 1) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                col--;
            } else if (target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
}
