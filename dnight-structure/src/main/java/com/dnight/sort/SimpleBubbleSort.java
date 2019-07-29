package com.dnight.sort;

/**
 * Author: dnight
 * Date: 2019/7/29 20:39
 */
public class SimpleBubbleSort {

    public static void main(String[] args) {
        SimpleBubbleSort sort = new SimpleBubbleSort();
        int[] arr = {11, 19, 0, -1, 5, 6, 16, -3, 6, 0, 14, 18, 7, 21, 18, -6, -8};
        sort.sort(arr);
        for (int value : arr) {
            System.out.print(value + ", ");
        }
    }

    public void sort(int[] arr) {
        //外层循环一次为一趟排序
        for (int i = 0; i < arr.length; i++) {
            //设置标识，判断这趟排序是否发生了交换。
            //如果未发生交换，则说明数组已经有序，不必再排序了
            boolean isSwap = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    isSwap = true;
                }
            }
            if (!isSwap) {
                break;
            }
        }
    }
}
