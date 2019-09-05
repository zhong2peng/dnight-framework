import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/9/5
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> generate = solution.generate(5);
        print(generate);
    }

    public static void print(List<List<Integer>> list) {
        for (List<Integer> l : list) {
            for (Integer i : l) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }
}
