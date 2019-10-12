/**
 * @author ZHONGPENG769
 * @date 2019/10/12
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] patterns = {
                "abab", "aaaa", "aabb"
        };
        String[] strs = {
                "redblueredblue", "asdasdasdasd", "xyzabcxzyabc"
        };
        for (int i = 0; i < patterns.length; i++) {
            System.out.println(solution.wordPatternMatch(patterns[i], strs[i]));
        }
    }
}
