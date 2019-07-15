/**
 * @author ZHONGPENG769
 * @date 2019/7/12
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] input = {
                "/home/",
                "/../",
                "/home//foo/",
                "/a/./b/../../c/",
                "/a/../../b/../c//.//",
                "/a//b////c/d//././/.."
        };
        for (String str : input) {
            System.out.println(solution.simplifyPath(str));
        }
    }
}
