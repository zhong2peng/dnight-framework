package com.dnight.sort;

/**
 * @author ZHONGPENG769
 * @date 2019/7/22
 */
public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        int[] arr = {};
        sort.sort(arr);
        for (int value : arr) {
            System.out.print(value + ", ");
        }
    }

    /**
     * 鸡尾酒排序，又称定向冒泡排序、搅拌排序等，是对冒泡排序的改进。
     * 在把最大的数往后面冒泡的同时，把最小的数也往前面冒泡，同时收缩无序区的左右边界，
     * 有序区在序列左右逐渐累积。
     *
     * @param arr
     */
    public void sort(int[] arr) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (arr[i] < arr[i - 1]) {
                    swap(arr, i, i - 1);
                }
            }
            left++;
        }
    }

    private void swap(int[] arr, int i, int i1) {
        int tmp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = tmp;
    }

}
