/**
 * @author ZHONGPENG769
 * @date 2019/10/11
 */
public class Solution extends Relation {

    /**
     * 在一个派对上有n个人，其中有一位名人。名人的定义是其他n-1个人都认识他，但他不认识任何一个人。
     * 要找出这位名人，只允许问A是否认识B。实施一个函数，找出名人，如果有返回他的label，如果没有返回-1。
     * 对于候选者i，遍历所有其他人j，如果i认识j，或者j不认识i，说明i不可能是名人，标记其为false
     * <p>
     * 解法2: 先设定候选人res为0，从1开始遍历数组，对于遍历到的人i，若候选人res认识i，则将候选人res设为i。
     * 第一次遍历完毕以后，再开始第二次遍历，来判断res是否确实为解。T: O(n), S: O(1)
     *
     * @param n
     * @return
     */
    public int findCelebrity(int n) {
        if (n <= 1) {
            return -1;
        }
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i != candidate && (knows(candidate, i)
                    || !knows(i, candidate))) {
                return -1;
            }
        }
        return candidate;
    }

    private boolean knows(int candidate, int i) {
        return true;
    }
}
