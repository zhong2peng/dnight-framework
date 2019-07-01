/**
 * @author ZHONGPENG769
 * @date 2019/7/1
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution.trap1(height));
        System.out.println(solution.trap2(height));
        System.out.println(solution.trap3(height));
        System.out.println(solution.trap4(height));
    }
}
