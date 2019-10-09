import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/10/9
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.getFactors(1));
        print(solution.getFactors(37));
        print(solution.getFactors(12));
        print(solution.getFactors(32));
    }

    public static void print(List<List<Integer>> list) {
        System.out.println();
        for (List<Integer> tmp : list) {
            System.out.print("[");
            for (Integer i : tmp) {
                System.out.print(i + ",");
            }
            System.out.print("]");
            System.out.println();
        }
    }
}
