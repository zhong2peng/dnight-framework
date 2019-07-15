import java.util.Arrays;

/**
 * @author ZHONGPENG769
 * @date 2019/7/12
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] inputs = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        int[][] inputs1 = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        solution.setZeroes(inputs);
        solution.setZeroes(inputs1);
        Arrays.asList(inputs).stream()
                .forEach(s -> {
                    Arrays.stream(s).forEach(f -> System.out.print(f + ","));
                    System.out.println();
                });


    }
}
