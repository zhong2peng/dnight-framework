import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/7/1
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        print(solution.groupAngrams1(strs));
        print(solution.groupAngrams2(strs));
    }

    public static void print(List<List<String>> lists) {
        for (List<String> tmp : lists) {
            for (String i : tmp) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }
    }
}
