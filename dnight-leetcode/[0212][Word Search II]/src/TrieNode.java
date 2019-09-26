/**
 * @author ZHONGPENG769
 * @date 2019/9/26
 */
public class TrieNode {

    public char val;
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];
    String word;

    public TrieNode() {
    }

    TrieNode(char c) {
        TrieNode node = new TrieNode();
        node.val = c;
    }
}
