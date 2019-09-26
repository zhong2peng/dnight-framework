import java.util.*;

/**
 * @author ZHONGPENG769
 * @date 2019/9/26
 */
public class Solution {

    /**
     * There are a total of n courses you have to take, labeled from 0 to n-1.
     * <p>
     * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
     * <p>
     * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
     * <p>
     * Example 1:
     * <p>
     * Input: 2, [[1,0]]
     * Output: true
     * Explanation: There are a total of 2 courses to take.
     * To take course 1 you should have finished course 0. So it is possible.
     * Example 2:
     * <p>
     * Input: 2, [[1,0],[0,1]]
     * Output: false
     * Explanation: There are a total of 2 courses to take.
     * To take course 1 you should have finished course 0, and to take course 0 you should
     * also have finished course 1. So it is impossible.
     * Note:
     * <p>
     * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
     * You may assume that there are no duplicate edges in the input prerequisites.
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 初始化图
        Map<Integer, List<Integer>> map = new HashMap<>();
        // 存储每个节点的入度
        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int first = prerequisites[i][0];
            int second = prerequisites[i][1];
            if (!map.containsKey(first)) {
                map.put(first, new ArrayList<>());
            }
            map.get(first).add(second);
            // 入度+1，从first->second
            indegree[second]++;
        }
        // 存储所有入度为0的结点
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        // 用来计算拓扑排序的节点个数
        int count = 0;
        while (!q.isEmpty()) {
            // 获取第一格入度为0的节点
            int val = q.poll();
            count++;
            if (!map.containsKey(val)) {
                continue;
            }
            List<Integer> tmp = map.get(val);
            for (int i = 0; i < tmp.size(); i++) {
                // 把所有的以val为开头的入度-1
                int idx = tmp.get(i);
                indegree[idx]--;
                // 如果入度为0，把该节点加入到队列中
                if (indegree[idx] == 0) {
                    q.offer(idx);
                }
            }
        }
        return count == numCourses;
    }
}
