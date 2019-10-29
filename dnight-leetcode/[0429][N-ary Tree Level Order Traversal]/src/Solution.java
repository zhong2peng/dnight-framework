import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ZHONGPENG769
 * @date 2019/10/29
 */
public class Solution {

    /**
     * Given an n-ary tree, return the level order traversal of its nodes' values.
     * (ie, from left to right, level by level).
     * <p>
     * For example, given a 3-ary tree:
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> inQueue = new LinkedList<>();
        Queue<Node> outQueue = new LinkedList<>();
        inQueue.add(root);
        while (!inQueue.isEmpty()) {
            List<Integer> tmp = new LinkedList<>();
            while (!inQueue.isEmpty()) {
                Node poll = inQueue.poll();
                if (poll.children != null) {
                    outQueue.addAll(poll.children);
                }
                tmp.add(poll.val);
            }
            result.add(tmp);
            inQueue.addAll(outQueue);
            outQueue.clear();

        }
        return result;
    }

    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> ret = new LinkedList<>();

        if (root == null) return ret;

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> curLevel = new LinkedList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node curr = queue.poll();
                curLevel.add(curr.val);
                for (Node c : curr.children)
                    queue.offer(c);
            }
            ret.add(curLevel);
        }

        return ret;
    }


}
