/**
 * @author ZHONGPENG769
 * @date 2019/6/26
 */
public class Main {

    public static void main(String[] args) {
        int[] A = {1, 3, 4, 2, 8, 3, 3, 1};
        int[] A1 = {1, 3, 4, 2, 8, 3, 3, 1};
        test1(A);
        test2(A1);
        for (int i : A) {
            System.out.print(i + "=>");
        }
        System.out.println();
        for (int i : A1) {
            System.out.print(i + "=>");
        }
    }

    public static void test1(int[] A) {
        System.out.println((new Solution1()).removeElement(A, 3));
    }

    public static void test2(int[] A) {
        System.out.println((new Solution2()).removeElement(A, 3));
    }

}
