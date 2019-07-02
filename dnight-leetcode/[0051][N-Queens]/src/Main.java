import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/7/2
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.solveNQueues(4));
//        print(solution.solveNQueues(8));
    }

    public static void print(List<List<String>> result) {
        for (List<String> list : result) {
            for (String str : list) {
                System.out.println(str + ", ");
            }
            System.out.println();
        }
    }
}
