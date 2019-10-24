package com.dnight.limitrarte.demo;

import java.util.Optional;
import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;

/**
 * @author ZHONGPENG769
 * @date 2019/10/24
 */
public class LeakyBucketLimiter implements RateLimiter {

    private static final int DEFAULT_RATE_LIMIT_PER_SECOND = Integer.MAX_VALUE;
    private static final long NANOSECOND = 1000 * 1000 * 1000;
    private BlockingQueue<Thread> bucket;

    public LeakyBucketLimiter() {
        this(DEFAULT_RATE_LIMIT_PER_SECOND);
    }

    public LeakyBucketLimiter(int limit) {
        if (limit <= 0) {
            throw new IllegalArgumentException();
        }
        bucket = new LinkedBlockingQueue<>(limit);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        TimestampHolder holder = new TimestampHolder(System.nanoTime());

        long interval = NANOSECOND / limit;
        executorService.submit(() -> {
            while (true) {
                long cur = System.nanoTime();
                if (cur - holder.getTimestamp() >= interval) {
                    Thread thread = bucket.poll();
                    Optional.ofNullable(thread).ifPresent(LockSupport::unpark);
                    holder.setTimestamp(cur);
                }
                TimeUnit.NANOSECONDS.sleep(1000);
            }
        });

    }

    @Override
    public void acquire() {
        if (bucket.remainingCapacity() == 0) {
            throw new RejectException();
        }
        Thread thread = Thread.currentThread();
        bucket.add(thread);
        LockSupport.park();
    }

    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = new LeakyBucketLimiter(1);

        Runnable runnable = () -> {
            int num = 100;
            while (num > 0) {
                try {
                    rateLimiter.acquire();
                } catch (Exception e) {
                    continue;
                }

                num--;
                System.out.println("Thread: " + Thread.currentThread().getName() + ", sec: " + System.currentTimeMillis() / 1000L + ", mil: " + System.currentTimeMillis() + " got a token");
            }
        };

        long start = System.currentTimeMillis();
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            threadPool.submit(runnable);
        }
        threadPool.awaitTermination(100, TimeUnit.SECONDS);
        long end = System.currentTimeMillis();
        System.out.println("over time: " + (end - start) / 1000);
    }
}
