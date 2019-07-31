package com.dnight.sort;

/**
 * Author: dnight
 * Date: 2019/7/29 20:31
 */
public class HeapSort {

    public void adjustHeap(int[] arr, int left, int right) {
        int temp = arr[left];
        for (int j = 2 * left; j < right; j *= 2) {
            if (arr[j] < arr[j + 1]) {
                ++j;
            }
            if (temp >= arr[j]) {
                break;
            }
            arr[left] = arr[j];
            left = j;
        }
        arr[left] = temp;
    }

    /**
     * 将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
     * 将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),
     * 且满足R[1,2…n-1]<=R[n]；
     * 由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，
     * 然后再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。
     * 不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。
     *
     * @param arr
     */
    public void sort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length - 1);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            adjustHeap(arr, 0, i - 1);
        }
    }

    public static void main(String[] args) {
        HeapSort sort = new HeapSort();
        int[] arr = {11, 19, 0, -1, 5, 6, 16, -3, 6, 0, 14, 18, 7, 21, 18, -6, -8};
        sort.sort(arr);
        for (int val : arr) {
            System.out.print(val + ", ");
        }
    }
}
