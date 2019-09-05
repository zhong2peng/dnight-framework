import java.util.LinkedList;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/9/5
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] t = {
                {2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3}
        };

        List<List<Integer>> tri = new LinkedList<>();
        for (int i = 0; i < t.length; i++) {
            List<Integer> line = new LinkedList<>();
            for (int j = 0; j < t[i].length; j++) {
                line.add(t[i][j]);
            }

            tri.add(line);
        }
        int minVal = solution.minimumTotal(tri);
        System.out.println(minVal);
    }
}
