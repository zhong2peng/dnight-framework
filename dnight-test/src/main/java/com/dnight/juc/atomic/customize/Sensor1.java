package com.dnight.juc.atomic.customize;

/**
 * Author: dnight
 * Date: 2019/8/5 23:14
 */
public class Sensor1 implements Runnable {
    private ParkingCounter parkingCounter;

    public Sensor1(ParkingCounter parkingCounter) {
        this.parkingCounter = parkingCounter;
    }

    @Override
    public void run() {
        parkingCounter.carIn();
        parkingCounter.carIn();
        parkingCounter.carIn();
        parkingCounter.carIn();
        parkingCounter.carOut();
        parkingCounter.carOut();
        parkingCounter.carOut();
        parkingCounter.carIn();
        parkingCounter.carIn();
        parkingCounter.carIn();
    }
}
