package com.dnight.sort;

/**
 * @author ZHONGPENG769
 * @date 2019/7/31
 */
public class MergeSort {

    /**
     * 把长度为n的输入序列分成两个长度为n/2的子序列；
     * 对这两个子序列分别采用归并排序；
     * 将两个排序好的子序列合并成一个最终的排序序列。
     *
     * @param arr
     * @param left
     * @param right
     */
    public void sort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) >> 1;
            sort(arr, left, middle);
            sort(arr, middle + 1, right);
            merge(arr, left, right);
        }
    }

    private void merge(int[] arr, int left, int right) {
        int middle = (left + right) >> 1;
        int i = left;
        int j = middle + 1;
        int count = 0;
        int[] temp = new int[right - left + 1];
        while (i <= middle && j <= right) {
            if (arr[i] < arr[j]) {
                temp[count++] = arr[i++];
            } else {
                temp[count++] = arr[j++];
            }
        }
        while (i <= middle) {
            temp[count++] = arr[i++];
        }
        while (j <= right) {
            temp[count++] = arr[j++];
        }
        count = 0;
        while (left <= right) {
            arr[left++] = temp[count++];
        }
    }

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] arr = {11, 19, 0, -1, 5, 6, 16, -3, 6, 0, 14, 18, 7, 21, 18, -6, -8};
        sort.sort(arr, 0, arr.length - 1);
        for (int val : arr) {
            System.out.print(val + ", ");
        }
    }
}
