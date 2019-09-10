import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/9/10
 */
public class Node {

    public int val;
    public List<Node> neighbors;

    public Node() {
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
