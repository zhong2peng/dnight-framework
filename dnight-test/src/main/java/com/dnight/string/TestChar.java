package com.dnight.string;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author ZHONGPENG769
 * @date 2019/10/28
 */
public class TestChar {

    public static void main(String[] args) {

        int i1 = 10;
        int i2 = 20;
        int k = 0;
        int res = ++k + k++ + k + k++ + ++k;
        // 1 1 1 1 2
        System.out.println(res);
        System.out.println("i1 - i2 = "+i1+i2);
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    queue.add(1);
                    System.out.println("produce");
                }
            }).start();
        }

        for (int i = 0; i < 35; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("consume" + queue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }


    }
}
