package com.dnight.sort;

/**
 * @author ZHONGPENG769
 * @date 2019/7/22
 */
public class BubbleSort {

    private int[] array;

    public BubbleSort(int[] array) {
        this.array = array;
    }

    public void bubbleSortImprovement() {
        int temp;
        int low = 0;
        int high = array.length - 1;
        int counter = 1;

        while (low < high) {
            for (int i = low; i < high; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            --high;
            for (int j = high; j > low; --j) {
                if (array[j] < array[j - 1]) {  //如果前一位大于后一位，交换位置
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
            ++low;
            System.out.print("第" + counter + "轮排序结果：");
            display();
            counter++;
        }
    }

    public void display() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 4, 11, 2, 20, 18};
        BubbleSort sort = new BubbleSort(a);
        System.out.print("未排序时的结果：");
        sort.display();
        sort.bubbleSortImprovement();
    }
}
