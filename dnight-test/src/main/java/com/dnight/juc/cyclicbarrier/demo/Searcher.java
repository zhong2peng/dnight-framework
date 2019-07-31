package com.dnight.juc.cyclicbarrier.demo;

import com.dnight.juc.cyclicbarrier.utils.MatrixMock;
import com.dnight.juc.cyclicbarrier.utils.Results;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author ZHONGPENG769
 * @date 2019/7/31
 */
public class Searcher implements Runnable {

    private int firstRow;
    private int lastRow;
    private MatrixMock mock;
    private Results results;
    private int number;

    private CyclicBarrier barrier;

    public Searcher(int firstRow, int lastRow, MatrixMock mock, Results results, int number, CyclicBarrier barrier) {
        this.firstRow = firstRow;
        this.lastRow = lastRow;
        this.mock = mock;
        this.results = results;
        this.number = number;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        System.out.printf("%s: Processing lines from %d to %d.\n", Thread.currentThread().getName(),
                firstRow, lastRow);
        int counter;
        for (int i = firstRow; i < lastRow; i++) {
            int[] row = mock.getRow(i);
            counter = 0;
            for (int j = 0; j < row.length; j++) {
                if (row[j] == number) {
                    counter++;
                }
            }
            results.setData(i, counter);
        }

        System.out.printf("%s: lines processed.\n", Thread.currentThread().getName());
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
