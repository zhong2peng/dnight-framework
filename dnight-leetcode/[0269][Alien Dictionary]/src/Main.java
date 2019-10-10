/**
 * @author ZHONGPENG769
 * @date 2019/10/10
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] str = {
                "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"
        };
        String s = solution.alienOrder(str);
        System.out.println(s);
    }
}
