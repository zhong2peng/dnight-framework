package com.dnight.juc.cyclicbarrier.utils;

/**
 * @author ZHONGPENG769
 * @date 2019/7/31
 */
public class Results {

    private int[] data;

    public Results(int size) {
        this.data = new int[size];
    }

    public void setData(int position, int value) {
        data[position] = value;
    }

    public int[] getData() {
        return data;
    }
}
