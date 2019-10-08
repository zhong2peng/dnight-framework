package com.dnight.distributed;

import java.util.GregorianCalendar;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 需要40位用于记录毫秒数
 * 需要6位记录区域
 * 需要7位记录毫秒内的序列号
 * 需要7位记录应用编号
 * 剩下4位进行保留
 * <p>
 * ---- ---------------------------------------- ------ ------- -------
 * |4   |40                                      |6     |7      |7      |
 * ---- ---------------------------------------- ------ ------- -------
 *
 * @author ZHONGPENG769
 * @date 2019/10/8
 */
public class DistributedIdGenerator {
    private static final long DEFAULT = 0;
    // 2019-01-01 00:00:00.000 距1900-01-01 00:00:00毫秒数
    private static final long START = new GregorianCalendar(2017, 0, 1, 0, 0, 0).getTimeInMillis();

    /**
     * 用于生成1毫秒内的序号，值的范围为[0, 127]
     */
    private final AtomicInteger seq = new AtomicInteger(0);

    /**
     * 区域编号
     */
    private long region = DEFAULT;

    /**
     * 应用编号
     */
    private long application = DEFAULT;

    /**
     * 保留位
     */
    private long reservation = DEFAULT;

    public DistributedIdGenerator() {
    }

    public DistributedIdGenerator(long region, long application, long reservation) {
        this.region = region;
        this.application = application;
        this.reservation = reservation;
    }

    public long getRegion() {
        return region;
    }

    public void setRegion(long region) {
        this.region = region;
    }

    public long getApplication() {
        return application;
    }

    public void setApplication(long application) {
        this.application = application;
    }

    public long getReservation() {
        return reservation;
    }

    public void setReservation(long reservation) {
        this.reservation = reservation;
    }

    /**
     * 获取从2019.01.01 00：00：00以来的毫秒数
     *
     * @return
     */
    public long getMillisecond() {
        return System.currentTimeMillis() - START;
    }

    /**
     * 下一个序列号
     *
     * @return
     */
    public long getNextNumber() {
        int n = seq.getAndIncrement();
        seq.compareAndSet(128, 0);
        return n;
    }

    public long next() {
        return (getReservation() << (40 + 6 + 7 + 7))
                + ((getMillisecond() << (6 + 7 + 7)))
                + (getRegion() << (7 + 7))
                + (getApplication() << 7)
                + getNextNumber();
    }

    public static String toString(long n) {
        StringBuilder builder = new StringBuilder(64);
        String s = Long.toBinaryString(n);
        for (int i = 0; i < 64 - s.length(); i++) {
            builder.append(0);
        }
        builder.append(s);
        return builder.toString();
    }

    public static void main(String[] args) throws InterruptedException {
        DistributedIdGenerator generator = new DistributedIdGenerator();
        CountDownLatch countDownLatch = new CountDownLatch(16);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 16; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(generator.next());
                }
            });
            countDownLatch.countDown();
        }
        countDownLatch.await();
    }
}
