package com.dnight.framework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ZHONGPENG769
 * @date 2019/7/9
 */
public class ThreadTest {
    private static class SynchronizedExample {

        public void func1() {
            synchronized (this) {
                for (int i = 0; i < 100; i++) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }

        public void func() {
            synchronized (ThreadTest.class) {
                for (int i = 0; i < 100; i++) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }

        public synchronized static void func2() {
            for (int i = 0; i < 100; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SynchronizedExample e1 = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(() -> e1.func1());
//        executorService.execute(() -> e1.func1());
        SynchronizedExample e2 = new SynchronizedExample();
        SynchronizedExample e3 = new SynchronizedExample();
//        executorService.execute(()-> e2.func1());
//        executorService.execute(()-> e3.func1());

//        executorService.execute(() -> e2.func());
//        executorService.execute(() -> e3.func());


    }
}
