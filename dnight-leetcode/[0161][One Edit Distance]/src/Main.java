/**
 * @author ZHONGPENG769
 * @date 2019/9/17
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isOneEditDistance("ab", "acb"));
        System.out.println(solution.isOneEditDistance("cab", "ad"));
        System.out.println(solution.isOneEditDistance("1203", "1213"));
    }
}
