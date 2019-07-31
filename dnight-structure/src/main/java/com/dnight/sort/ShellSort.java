package com.dnight.sort;

/**
 * @author ZHONGPENG769
 * @date 2019/7/31
 */
public class ShellSort {

    /**
     * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：
     * <p>
     * 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
     * 按增量序列个数k，对序列进行k 趟排序；
     * 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
     * 仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     *
     * @param arr
     */
    public void sort(int[] arr) {
        int len = arr.length;
        int i, j, gap;
        for (gap = len / 2; gap > 0; gap /= 2) {
            System.out.println("gap: " + gap);
            for (i = gap; i < len; i++) {
                int num = arr[i];
                for (j = i - gap; j >= 0 && arr[j] > num; j -= gap) {
                    arr[j + gap] = arr[j];
                }
                arr[j + gap] = num;
            }
        }
    }

    public static void main(String[] args) {
        ShellSort sort = new ShellSort();
        int[] arr = {11, 19, 0, -1, 5, 6, 16, -3, 6, 0, 14, 18, 7, 21, 18, -6, -8};
        sort.sort(arr);
        for (int val : arr) {
            System.out.print(val + ",");
        }
    }
}
