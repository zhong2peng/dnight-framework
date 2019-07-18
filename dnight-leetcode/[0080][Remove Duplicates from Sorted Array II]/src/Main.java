/**
 * @author ZHONGPENG769
 * @date 2019/7/18
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] inputs = {1, 1, 1, 2, 2, 3};
        int[] inputs1 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
//        System.out.println(solution.removeDuplicates(inputs));
        System.out.println(solution.removeDuplicates1(inputs));
//        System.out.println(Arrays.toString(inputs));
        System.out.println(solution.removeDuplicates(inputs1));

        System.out.println(solution.removeDuplicates1(inputs1));
    }
}
