/**
 * @author ZHONGPENG769
 * @date 2019/8/13
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(solution.isInterleave1("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(solution.isInterleave1("aabcc", "dbbca", "aadbbbaccc"));
    }
}
