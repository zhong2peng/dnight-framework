/**
 * @author ZHONGPENG769
 * @date 2019/7/26
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}

        };
        System.out.println(solution.maximalRectangle(matrix));
    }
}
