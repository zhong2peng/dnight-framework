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
     * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
     * <p>
     * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
     * <p>
     * Example 1:
     * <p>
     * Input: 2, [[1,0]]
     * Output: [0,1]
     * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
     * course 0. So the correct course order is [0,1] .
     * Example 2:
     * <p>
     * Input: 4, [[1,0],[2,0],[3,1],[3,2]]
     * Output: [0,1,2,3] or [0,2,1,3]
     * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
     * courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
     * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
     * Note:
     * <p>
     * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
     * You may assume that there are no duplicate edges in the input prerequisites.
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 入度
        int[] incLinkCounts = new int[numCourses];
        List<List<Integer>> adjs = new ArrayList<>(numCourses);
        initialiseGraph(incLinkCounts, adjs, prerequisites);
        return solveByBFS(incLinkCounts, adjs);
    }

    private int[] solveByBFS(int[] incLinkCounts, List<List<Integer>> adjs) {
        int[] order = new int[incLinkCounts.length];
        Queue<Integer> toVisit = new ArrayDeque<>();
        for (int i = 0; i < incLinkCounts.length; i++) {
            if (incLinkCounts[i] == 0) {
                toVisit.offer(i);
            }
        }
        int visited = 0;
        while (!toVisit.isEmpty()) {
            int from = toVisit.poll();
            order[visited++] = from;
            for (int to : adjs.get(from)) {
                // 不可能为负数，入度必定大于0
                incLinkCounts[to]--;
                if (incLinkCounts[to] == 0) {
                    // 为0就可以直接访问
                    toVisit.offer(to);
                }
            }
        }
        return visited == incLinkCounts.length ? order : new int[0];
    }

    private void initialiseGraph(int[] incLinkCounts, List<List<Integer>> adjs, int[][] prerequisites) {
        int n = incLinkCounts.length;
        while (n-- > 0) {
            adjs.add(new ArrayList<>());
        }
        for (int[] edgs : prerequisites) {
            incLinkCounts[edgs[0]]++;
            // [0, 1]  1 -> 0
            adjs.get(edgs[1]).add(edgs[0]);
        }
    }
}
