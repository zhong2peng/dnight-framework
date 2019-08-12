import java.util.List;

/**
 * Author: dnight
 * Date: 2019/8/12 23:10
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.restoreIpAddresses("25525511135");
        for (String val : strings) {
            System.out.print(val + ",");
        }
    }
}
