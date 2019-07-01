/**
 * @author ZHONGPENG769
 * @date 2019/7/1
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("aa", "a"));
        System.out.println(solution.isMatch("aa", "aa"));
        System.out.println(solution.isMatch("aaa", "aa"));
        System.out.println(solution.isMatch("aa", "*"));
        System.out.println(solution.isMatch("aa", "a*"));
        System.out.println(solution.isMatch("ab", "?*"));
        System.out.println(solution.isMatch("aab", "c*a*b"));
        System.out.println(solution.isMatch("adceb", "*a*b"));
    }
}
