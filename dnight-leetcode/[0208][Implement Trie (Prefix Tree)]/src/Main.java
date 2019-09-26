import com.sun.tools.javac.util.Assert;

/**
 * @author ZHONGPENG769
 * @date 2019/9/26
 */
public class Main {

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        Assert.check(trie.search("apple") == true);   // returns true
        Assert.check(trie.search("app") == false);     // returns false
        Assert.check(trie.startsWith("app") == true); // returns true
        trie.insert("app");
        Assert.check(trie.search("app") == true);     // returns true
    }
}
