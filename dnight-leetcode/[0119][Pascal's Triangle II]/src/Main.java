import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/9/5
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> row = solution.getRow(3);
        for (Integer i : row) {
            System.out.print(i + ",");
        }
    }
}
