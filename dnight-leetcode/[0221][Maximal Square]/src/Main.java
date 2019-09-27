/**
 * @author ZHONGPENG769
 * @date 2019/9/27
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] matrix = {
                "10100".toCharArray(),
                "10111".toCharArray(),
                "11111".toCharArray(),
                "10010".toCharArray()
        };
        int i = solution.maximalSquare(matrix);
        System.out.println(i);

    }
}
