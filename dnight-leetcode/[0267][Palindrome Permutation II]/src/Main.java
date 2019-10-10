import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/10/10
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.generatePalindromes("aabb"));
        print(solution.generatePalindromes("abc"));
        System.out.println("baab".substring(1, 3));
    }

    public static void print(List<String> list) {
        for (String str : list) {
            System.out.print(str + ", ");
        }
        System.out.println();
    }
}
