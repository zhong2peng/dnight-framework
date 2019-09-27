import java.util.Random;

/**
 * @author ZHONGPENG769
 * @date 2019/9/27
 */
public class Solution {

    /**
     * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted partition,
     * not the kth distinct element.
     * <p>
     * Example 1:
     * <p>
     * Input: [3,2,1,5,6,4] and k = 2
     * Output: 5
     * Example 2:
     * <p>
     * Input: [3,2,3,1,2,4,5,5,6] and k = 4
     * Output: 4
     * Note:
     * You may assume k is always valid, 1 ≤ k ≤ array's length.
     * <p>
     * 找出一个非排序数组中第k大的元素。
     * <p>
     * 解法1：排序法。使用常规排序方法后找到数组中对应下标的值。
     * <p>
     * 解法2：将数组内容存入一升序优先队列中，进行k-1次pop操作，那么队尾的元素就是第k大的数字。
     * <p>
     * 解法3：最大堆MaxHeap。使用数组内容构建一个最大堆，通过每次pop出堆顶后继续维护堆的结构，
     * 直到满足一定的次数（最大堆k-1次，最小堆size-k次），堆顶的元素就是第k大的数字，实现的效果与优先队列相同。
     * <p>
     * 解法4：Quick Select, 利用快排的partition函数思想，选定一个数组内的值作为pivot，将小于pivot的数字放到pivot右边，
     * 大于等于pivot的数字放到pivot左边。接着判断两边数字的数量，如果左边的数量小于k个，说明第k大的数字存在于pivot及pivot右边的区域之内，
     * 对右半区执行partition函数；如果右边的数量小于k个，说明第k大的数字在pivot和pivot左边的区域之内，对左半区执行partition函数。
     * 直到左半区刚好有k-1个数，那么第k大的数就已经找到了。
     * <p>
     * 快排回顾：
     * 它采用了 分治法 的思想：
     * <p>
     * 1. 从数列中取出一个数作为基准数（枢轴，pivot）。
     * 2. 将数组进行划分(partition)，将比基准数大的元素都移至枢轴右边，将小于等于基准数的元素都移至枢轴左边。
     * 3. 再对左右的子区间重复第二步的划分操作，直至每个子区间只有一个元素。
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        return partition(nums, 0, len - 1, len + 1 - k);
    }

    private int partition(int[] nums, int low, int high, int n) {
        int random = new Random().nextInt(high - low + 1) + low;
        swap(nums, random, low);
        int pivot = nums[low], p1 = low;
        for (int i = low + 1; i <= high; i++) {
            if (nums[i] < pivot) {
                p1++;
                swap(nums, p1, i);
            }
        }
        swap(nums, low, p1);
        if (p1 == n - 1) {
            return pivot;
        } else if (p1 > n - 1) {
            return partition(nums, low, p1 - 1, n);
        } else {
            return partition(nums, p1 + 1, high, n);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
