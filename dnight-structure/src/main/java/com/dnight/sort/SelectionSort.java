package com.dnight.sort;

/**
 * @author ZHONGPENG769
 * @date 2019/7/31
 */
public class SelectionSort {

    /**
     * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
     * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     * 以此类推，直到所有元素均排序完毕。
     *
     * @param arr
     */
    public void sort(int[] arr) {
        int len = arr.length;
        int minIdx, tmp;
        for (int i = 0; i < len - 1; i++) {
            minIdx = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            tmp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = tmp;
        }
    }

    public static void main(String[] args) {
        SelectionSort sort = new SelectionSort();
        int[] arr = {11, 19, 0, -1, 5, 6, 16, -3, 6, 0, 14, 18, 7, 21, 18, -6, -8};
        sort.sort(arr);
        for (int val : arr) {
            System.out.print(val + ", ");
        }
    }
}
