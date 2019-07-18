/**
 * @author ZHONGPENG769
 * @date 2019/7/15
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] inputs = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}

        };
        System.out.println(solution.exist(inputs, "ABCCED"));
        System.out.println(solution.exist(inputs, "SEE"));
        System.out.println(solution.exist(inputs, "ABCB"));
    }
}
