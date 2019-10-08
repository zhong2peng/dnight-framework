import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/10/8
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> list = solution.findStrobogrammatic(3);
        list.stream().forEach(s -> {
            System.out.print(s + ",");
        });
    }
}
