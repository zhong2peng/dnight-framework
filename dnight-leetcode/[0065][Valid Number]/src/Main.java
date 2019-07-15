/**
 * @author ZHONGPENG769
 * @date 2019/7/12
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] inputs = {
                "0",
                " 0.1 ",
                "abc",
                "1 a",
                "2e10",
                " -90e3   ",
                " 1e",
                "e3",
                " 6e-1",
                " 99e2.5 ",
                "53.5e93",
                " --6 ",
                "-+3",
                "95a54e53"
        };
        for (String str : inputs) {
            System.out.println(str + " => " + solution.isNumber(str));
        }

    }
}
