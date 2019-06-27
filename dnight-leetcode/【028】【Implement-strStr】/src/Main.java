/**
 * @author ZHONGPENG769
 * @date 2019/6/26
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(new Solution().strStr("abc", "ab"));
        System.out.println(new Solution().strStr("abcabc", "cab"));
        System.out.println(new Solution().strStr("aaaaaaaaaa", "aa"));
        System.out.println(new Solution().strStr("aaddvvddaa", "gg"));
        System.out.println(new Solution().strStr("abcdefedcba", "feda"));
        System.out.println(new Solution().strStr("abcdefedcba", "edc"));
    }
}
