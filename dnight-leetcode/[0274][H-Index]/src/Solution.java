import java.util.Arrays;

/**
 * @author ZHONGPENG769
 * @date 2019/10/10
 */
public class Solution {

    /**
     * Given an array of citations (each citation is a non-negative integer) of a researcher,
     * write a function to compute the researcher's h-index.
     * <p>
     * According to the definition of h-index on Wikipedia:
     * "A scientist has index h if h of his/her N papers have at least h citations each,
     * and the other N − h papers have no more than h citations each."
     * <p>
     * Example:
     * <p>
     * Input: citations = [3,0,6,1,5]
     * Output: 3
     * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
     * received 3, 0, 6, 1, 5 citations respectively.
     * Since the researcher has 3 papers with at least 3 citations each and the remaining
     * two with no more than 3 citations each, her h-index is 3.
     * Note: If there are several possible values for h, the maximum one is taken as the h-index.
     * <p>
     * h 因子是评判学术成就的一种重要方法，h 因子越高越好，h 因子兼顾研究学术人员的学术产出数量与学术产出质量。假设一个研究者的 h 因子为 10，则表明该研究者被引用次数大于等于 10 的文章数量也应大于等于 10。
     * <p>
     * 明白了 h 因子意思，我们看题目给定实例 citations = [3, 0, 6, 1, 5]，为什么是3呢？
     * 因为引用次数大于等于3的文章为citations = [3, 0, 6, 1, 5]，  (3, 6, 5)
     * 蓝颜色部分，显然判定该学者 h 因子为6或者5是不合适的。
     *
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        int level = 0;
        for (int i = 0; i < citations.length; i++) {
            level = Math.min(level, Math.min(citations.length - i, citations[i]));
        }
        return level;
    }
}
