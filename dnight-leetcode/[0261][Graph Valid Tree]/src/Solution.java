import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZHONGPENG769
 * @date 2019/10/9
 */
public class Solution {

    /**
     * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
     * write a function to check whether these edges make up a valid tree.
     * <p>
     * For example:
     * <p>
     * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
     * <p>
     * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
     * <p>
     * Hint:
     * <p>
     * Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree?
     * According to the definition of tree on Wikipedia:
     * “a tree is an undirected graph in which any two vertices are connected by exactly one path.
     * In other words, any connected graph without simple cycles is a tree.”
     * <p>
     * Note: you can assume that no duplicate edges will appear in edges.
     * Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
     * <p>
     * 给了我们一个无向图，让我们来判断其是否为一棵树，我们知道如果是树的话，所有的节点必须是连接的，
     * 也就是说必须是连通图，而且不能有环，所以我们的焦点就变成了验证是否是连通图和是否含有环。
     * <p>
     * DFS
     *
     * @param n
     * @param edges
     * @return
     */
    public boolean validTree(int n, int[][] edges) {
        // 节点和边
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            map.put(i, list);
        }

        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        if (!helper(0, -1, map, visited)) {
            return false;
        }

        //  然后我们在看v里面是否还有没被访问过的节点，如果有，则说明图不是完全连通的，返回false，反之返回true
        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }

        return true;
    }

    /**
     * 遍历的思想是，当DFS到某个节点，先看当前节点是否被访问过，
     * 如果已经被访问过，说明环存在，直接返回false，
     * 如果未被访问过，我们现在将其状态标记为已访问过，
     * 然后我们到邻接链表里去找跟其相邻的节点继续递归遍历，
     * <p>
     * 注意我们还需要一个变量pre来记录上一个节点，以免回到上一个节点，这样遍历结束后，
     * 我们就把和节点0相邻的节点都标记为true，
     * 然后我们在看v里面是否还有没被访问过的节点，如果有，则说明图不是完全连通的，返回false，反之返回true
     *
     * @param curr
     * @param parent
     * @param map
     * @param visited
     * @return
     */
    private boolean helper(int curr, int parent, Map<Integer, List<Integer>> map, boolean[] visited) {
        if (visited[curr]) {
            return false;
        }

        visited[curr] = true;

        for (int i : map.get(curr)) {
            if (i != parent && !helper(i, curr, map, visited)) {
                return false;
            }
        }

        return true;
    }
}
