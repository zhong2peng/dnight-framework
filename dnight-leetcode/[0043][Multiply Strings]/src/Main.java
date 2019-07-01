/**
 * @author ZHONGPENG769
 * @date 2019/7/1
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String num1 = "";
        String num2 = "";
        System.out.println(solution.multiply(num1, num2));
        num1 = "1";
        System.out.println(solution.multiply(num1, num2));
        num1 = "2";
        num2 = "3";
        System.out.println(solution.multiply(num1, num2));
        num1 = "123";
        num2 = "456";
        System.out.println(solution.multiply(num1, num2));
    }
}
