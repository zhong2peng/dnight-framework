import java.util.ArrayList;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/9/26
 */
public class Solution {

    /**
     * Given a 2D board and a list of words from the dictionary, find all words in the board.
     * <p>
     * Each word must be constructed from letters of sequentially adjacent cell,
     * where "adjacent" cells are those horizontally or vertically neighboring.
     * The same letter cell may not be used more than once in a word.
     * <p>
     * <p>
     * <p>
     * Example:
     * <p>
     * Input:
     * board = [
     * ['o','a','a','n'],
     * ['e','t','a','e'],
     * ['i','h','k','r'],
     * ['i','f','l','v']
     * ]
     * words = ["oath","pea","eat","rain"]
     * <p>
     * Output: ["eat","oath"]
     * <p>
     * <p>
     * Note:
     * <p>
     * All inputs are consist of lowercase letters a-z.
     * The values of words are distinct.
     * <p>
     * 给定一个二维矩阵(由字母组成)，以及一个单词词典，请在二维矩阵中找到所有在字典中出现的单词。使用二维矩阵构造单词的时候，
     * 单词中相邻的字母必须在二维矩阵中也相邻(垂直方向或者水平方向)，且在构造同一个单词时，二维矩阵中的同一个字母不可以重复使用
     * <p>
     * 我们可以根据字典中出现的单词构造一棵字典树(Trie)。当从二维矩阵的某一点出发进行深度优先搜索时，搜索路径上的字母构成了单词的前缀，检索字典树，
     * 看是否存在该前缀：
     * <p>
     * 如果不存在该前缀，则回溯并重新搜索(剪枝)；
     * 如果存在该前缀，则继续搜索，并将搜索路径上出现过的单词进行记录，即为答案。
     *
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.children[c - 'a'] == null) {
            return;
        }
        p = p.children[c - 'a'];
        if (p.isWord) {
            res.add(p.word);
            p.word = null;
            p.isWord = false;
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j, p, res);
        if (j > 0) dfs(board, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, i + 1, j, p, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
        board[i][j] = c;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.children[i] == null) {
                    p.children[i] = new TrieNode();
                }
                p = p.children[i];
            }
            p.isWord = true;
            p.word = w;
        }
        return root;
    }
}
