/**
 * @author ZHONGPENG769
 * @date 2019/7/18
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] inputs = {2, 5, 6, 0, 0, 1, 2};
        int[] inputs1 = {2, 5, 6, 0, 0, 1, 2};
        System.out.println(solution.search(inputs, 0));
        System.out.println(solution.search1(inputs, 0));
        System.out.println(solution.search(inputs1, 3));
        System.out.println(solution.search1(inputs1, 3));
    }
}
