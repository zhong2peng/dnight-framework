/**
 * @author ZHONGPENG769
 * @date 2019/6/27
 */
public class Main {

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println(new Solution().findSubstring(s, words));
        s = "wordgoodstudentgoodword";
        String[] words1 = {"word", "good", "good"};
        System.out.println(new Solution().findSubstring(s, words1));
        String[] words2 = {"word", "good"};
        System.out.println(new Solution().findSubstring(s, words2));
        s = "gooddwordgoodgoodstudentgoodword";
        System.out.println(new Solution().findSubstring(s, words1));
    }
}
