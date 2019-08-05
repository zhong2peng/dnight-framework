package com.dnight.juc.atomic.customize;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: dnight
 * Date: 2019/8/5 23:01
 */
public class ParkingCounter extends AtomicInteger {
    private static final long serialVersionUID = 1L;
    private int maxNumber;

    public ParkingCounter(int maxNumber) {
        set(0);
        this.maxNumber = maxNumber;
    }

    public boolean carIn() {
        for (; ; ) {
            int value = get();
            if (value == maxNumber) {
                System.out.println("ParkingCounter: The parking is full.");
                return false;
            } else {
                int newValue = value + 1;
                boolean changed = compareAndSet(value, newValue);
                if (changed) {
                    System.out.println("ParkingCounter: A car has entered.");
                    return true;
                }
            }
        }
    }

    public boolean carOut() {
        for (; ; ) {
            int value = get();
            if (value == 0) {
                System.out.println("ParkingCounter: The parking is empty.");
                return false;
            } else {
                int newValue = value - 1;
                boolean changed = compareAndSet(value, newValue);
                if (changed) {
                    System.out.println("ParkingCounter: The car has gone out.");
                    return true;
                }
            }
        }
    }
}
