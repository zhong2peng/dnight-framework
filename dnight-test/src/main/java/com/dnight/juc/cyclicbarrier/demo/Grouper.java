package com.dnight.juc.cyclicbarrier.demo;

import com.dnight.juc.cyclicbarrier.utils.Results;

/**
 * @author ZHONGPENG769
 * @date 2019/7/31
 */
public class Grouper implements Runnable {

    private Results results;

    public Grouper(Results results) {
        this.results = results;
    }

    @Override
    public void run() {
        int finalResult = 0;
        System.out.printf("Grouper: Processing results...\n");
        int[] data = results.getData();
        for (int number : data) {
            finalResult += number;
        }
        System.out.printf("Grouper: Total result: %d.\n", finalResult);
    }
}
