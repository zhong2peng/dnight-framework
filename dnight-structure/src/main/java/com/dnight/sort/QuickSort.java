package com.dnight.sort;

/**
 * Author: dnight
 * Date: 2019/7/29 20:01
 */
public class QuickSort {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] A = {11, 19, 0, -1, 5, 6, 16, -3, 6, 0, 14, 18, 7, 21, 18, -6, -8};
        quickSort.sort(A, 0, A.length - 1);
        for (int i : A) {
            System.out.print(i + ",");
        }
    }

    /**
     * @param A
     * @param low
     * @param high
     */
    public void sort(int[] A, int low, int high) {
        if (low >= high) {
            return;
        }
        int pos = split(A, low, high);
        sort(A, low, pos - 1);
        sort(A, pos + 1, high);
    }

    /**
     * 从数列中挑出一个元素，称为 “基准”（pivot），
     * 2 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
     * 在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
     * 3 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     *
     * @param A
     * @param low
     * @param high
     * @return
     */
    private int split(int[] A, int low, int high) {
        int pivot = low;
        int i = low + 1;
        int j = high;
        while (i <= j) {
            if (A[i] <= A[pivot]) {
                i++;
                continue;
            }
            if (A[j] > A[pivot]) {
                j--;
                continue;
            }
            // A[i] > A[pivot] or A[j] <= A[pivot]
            swap(A, i++, j--);
        }
        if (A[pivot] > A[j]) {
            swap(A, pivot, j);
            return j;
        }
        return pivot;
    }

    private void swap(int[] A, int pivot, int j) {
        int tmp = A[pivot];
        A[pivot] = A[j];
        A[j] = tmp;
    }
}
