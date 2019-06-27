/**
 * @author ZHONGPENG769
 * @date 2019/6/26
 */
public class Main {
    public static void main(String[] args) {
        int[] A1 = {1, 1, 2, 3, 4, 5, 5, 5, 5, 5, 6};
        int[] A2 = {1, 1, 2, 3, 4, 5, 5, 5, 5, 5, 6};
        test1(A1);
        test2(A2);
    }

    public static void test1(int[] A) {
        System.out.println((new Solution1()).removeDumplicates(A));
    }

    public static void test2(int[] A) {
        System.out.println((new Solution2()).removeDumplicates(A));
    }
}
