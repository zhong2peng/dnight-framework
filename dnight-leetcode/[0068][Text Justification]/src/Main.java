/**
 * @author ZHONGPENG769
 * @date 2019/7/12
 */
public class Main {

    public static void main(String[] args) {
        String[] strings = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWodth = 16;
        Solution solution = new Solution();
        System.out.println(solution.fullJustify(strings, maxWodth));
    }
}
