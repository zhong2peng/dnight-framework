/**
 * @author ZHONGPENG769
 * @date 2019/9/26
 */
public class WordDictionary {

    Trier root = new Trier();

    /**
     * Design a data structure that supports the following two operations:
     *
     * void addWord(word)
     * bool search(word)
     * search(word) can search a literal word or a regular expression string containing only
     * letters a-z or .. A . means it can represent any one letter.
     *
     * 设计数据结构能接受正则查找。该正则的设计的是’.'匹配任意字符。
     */

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {

    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        Trier pointer = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (pointer.children[c - 'a'] == null) {
                pointer.children[c - 'a'] = new Trier();
            }
            pointer = pointer.children[c - 'a'];
        }
        pointer.flag = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        Trier pointer = root;
        return helper(word, 0, pointer);
    }

    private boolean helper(String word, int start, Trier cur) {
        if (start == word.length()) {
            return cur.flag;
        }
        char c = word.charAt(start);
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (cur.children[i] != null) {
                    if (helper(word, start + 1, cur.children[i])) {
                        return true;
                    }
                }
            }
        } else {
            if (cur.children[c - 'a'] == null) {
                return false;
            } else {
                return helper(word, start + 1, cur.children[c - 'a']);
            }
        }
        return false;
    }
}
