/**
 * @author ZHONGPENG769
 * @date 2019/9/19
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] tmp = "hello world! zp".toCharArray();
        solution.reverseWords(tmp);
        System.out.println(new String(tmp));
    }
}
