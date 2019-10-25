package com.dnight.juc;

/**
 * @author ZHONGPENG769
 * @date 2019/10/24
 */
public class ThreadTest {

    public static void main(String[] args) {
        new ThreadTest().go();
    }

    private void go() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("foo");
            }
        };
        new Thread(r).start();
    }
}
