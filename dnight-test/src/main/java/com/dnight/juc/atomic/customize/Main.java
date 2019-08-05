package com.dnight.juc.atomic.customize;

/**
 * Author: dnight
 * Date: 2019/8/5 23:16
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        ParkingCounter counter = new ParkingCounter(5);
        Sensor1 sensor1 = new Sensor1(counter);
        Sensor2 sensor2 = new Sensor2(counter);
        Thread thread1 = new Thread(sensor1);
        Thread thread2 = new Thread(sensor2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.printf("Main: Number of cars: %d\n", counter.get());
        System.out.println("Main: End of the program.");
    }
}
