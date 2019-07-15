import java.util.LinkedList;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/7/15
 */
public class Solution1 {

    private List<List<Integer>> result;
    private List<Integer> l;
    private int[] set;
    private int num;

    /**
     * 递归分治算法
     *
     * @param S
     * @return
     */
    public List<List<Integer>> subsets(int[] S) {
        result = new LinkedList<>();
        if (S != null) {
            l = new LinkedList<>();
            quickSort(S, 0, S.length - 1);
            set = S;
            for (int i = 0; i <= S.length; i++) {
                num = i;
                subsets(0);
            }
        }
        set = null;
        l = null;
        return result;
    }

    private void subsets(int start) {
        if (num == 0) {
            List<Integer> tmp = new LinkedList<>();
            for (Integer i : l) {
                tmp.add(i);
            }
            result.add(tmp);
            return;
        }
        int endFirst = set.length - num;
        for (int i = start; i <= endFirst; i++) {
            l.add(set[i]);
            num--;
            subsets(i + 1);
            num++;
            l.remove((Integer) set[i]);
        }
    }

    private void quickSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int mid = getMid(arr, lo, hi);
            quickSort(arr, lo, mid - 1);
            quickSort(arr, mid + 1, hi);
        }
    }

    private int getMid(int[] arr, int lo, int hi) {
        int tmp = arr[lo];
        while (lo < hi) {
            while (lo < hi && arr[hi] > tmp) {
                hi--;
            }
            arr[lo] = arr[hi];
            while (lo < hi && arr[lo] < tmp) {
                lo++;
            }
            arr[hi] = arr[lo];
        }
        arr[lo] = tmp;
        return lo;
    }
}
