import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author ZHONGPENG769
 * @date 2019/9/10
 */
public class Solution {

    /**
     * Given a reference of a node in a connected undirected graph,
     * return a deep copy (clone) of the graph. Each node in the graph contains a val (int) and a list
     * (List[Node]) of its neighbors.
     * BFS
     *
     * @param node
     * @return
     */
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        //DFS，poll, offer，栈
        Queue<Node> queue = new LinkedList<>();
        //索引，数值和节点
        Map<Integer, Node> map = new HashMap<>();
        queue.offer(node);

        Node n = new Node();
        n.val = node.val;
        n.neighbors = new LinkedList<>();
        map.put(n.val, n);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node temp : cur.neighbors) {
                if (!map.containsKey(temp.val)) {
                    n = new Node();
                    n.val = temp.val;
                    n.neighbors = new LinkedList<>();
                    map.put(n.val, n);
                    queue.offer(temp);
                }
                map.get(cur.val).neighbors.add(map.get(temp.val));
            }
        }
        return map.get(node.val);
    }
}
