/**
 * @author ZHONGPENG769
 * @date 2019/7/15
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] inputs = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(solution.searchMatrix(inputs, 3));
        System.out.println(solution.searchMatrix(inputs, 13));
    }
}
