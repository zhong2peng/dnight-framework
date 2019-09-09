import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/9/9
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new LinkedList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        solution.findLadders(beginWord, endWord, wordList);
        System.out.println(111);
    }
}
