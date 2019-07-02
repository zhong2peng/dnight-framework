import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/7/2
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        List<Integer> list = solution.spiralOrder(matrix);
        list.stream().forEach(e -> System.out.print(e + ", "));
    }
}
