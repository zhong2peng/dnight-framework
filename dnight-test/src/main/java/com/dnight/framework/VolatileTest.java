package com.dnight.framework;

/**
 * @author ZHONGPENG769
 * @date 2019/6/19
 */
public class VolatileTest {
    private static volatile Integer num = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int k = 0; k < 10000; k++) {
                        num = num + 1;
                    }
                }
            });
            threads[i].start();
        }
        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }
        System.out.println(num);
    }
}
