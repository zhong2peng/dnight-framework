/**
 * @author ZHONGPENG769
 * @date 2019/9/26
 */
public class Trie {
    /**
     * Trie树，又称为字典树、单词查找树或者前缀树，是一种用于快速检索的多叉数结构。例如，英文字母的字典树是26叉数，数字的字典树是10叉树。
     * Trie树的基本性质有三点，归纳为：
     * <p>
     * 根节点不包含字符，根节点外每一个节点都只包含一个字符。
     * 从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串。
     * 每个节点的所有子节点包含的字符串不相同。
     */

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
        root.val = ' ';
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.children[c - 'a'] == null) {
                ws.children[c - 'a'] = new TrieNode(c);
            }
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.children[c - 'a'] == null) {
                return false;
            }
            ws = ws.children[c - 'a'];
        }
        return ws.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode ws = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (ws.children[c - 'a'] == null) {
                return false;
            }
            ws = ws.children[c - 'a'];
        }
        return true;
    }
}
