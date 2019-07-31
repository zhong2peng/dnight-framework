package com.dnight.juc.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author ZHONGPENG769
 * @date 2019/7/31
 */
public class VideoConference implements Runnable {

    private final CountDownLatch controller;

    public VideoConference(int number) {
        this.controller = new CountDownLatch(number);
    }

    public void arrive(String name) {
        System.out.printf("%s has arrived. \n", name);
        controller.countDown();
        System.out.printf("VideoConference: Waiting for %d participants. \n", controller.getCount());
    }

    @Override
    public void run() {
        System.out.printf("VideoConference: Initialization: %d participants. \n", controller.getCount());
        try {
            controller.await();
            System.out.printf("VideoConference: All the participants have arrived.\n");
            System.out.printf("VideoConference: Let's start...\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
