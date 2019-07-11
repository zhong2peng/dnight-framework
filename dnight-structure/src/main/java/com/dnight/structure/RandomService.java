package com.dnight.structure;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ZHONGPENG769
 * @date 2019/7/10
 */
public class RandomService {
    private ReentrantLock lock = new ReentrantLock();
    private AtomicLong resetCounter = new AtomicLong(0);
    private HashFunction sha256 = Hashing.sha256();

    private int resetThreshold = 10000;
    private Charset encoding = Charset.forName("UTF-8");
    private SecureRandom random;

    public RandomService() {
        this.resetSecureRandom();
    }

    private void resetSecureRandom() {
        this.lock.lock();
        try {
            this.random = SecureRandom.getInstance("NativePRNGNonBlocking");
            this.random.generateSeed(32);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } finally {
            this.lock.unlock();
        }
    }

    private String getToken() {
        if (this.resetCounter.incrementAndGet() > this.resetThreshold) {
            this.resetSecureRandom();
            this.resetCounter.set(0);
        }
        byte[] bytes = new byte[32];
        this.random.nextBytes(bytes);
        byte[] seedBytes = UUID.randomUUID().toString().getBytes(this.encoding);
        byte[] seeds = new byte[seedBytes.length + bytes.length];
        System.arraycopy(bytes, 0, seeds, 0, bytes.length);
        System.arraycopy(seedBytes, 0, seeds, bytes.length - 1, seedBytes.length);
        return this.sha256.hashBytes(bytes).toString();
    }

    /**
     * 生成token
     *
     * @param args
     */
    public static void main(String[] args) {
        RandomService randomService = new RandomService();
        List<String> list = new ArrayList<>(200000);
        List<String> repetition = new ArrayList<>();
        for (int i = 0; i < 200000; i++) {
            String t = randomService.getToken();
            if (list.contains(t)) {
                repetition.add(t);
            } else {
                list.add(t);
            }
            System.out.println(t);
            System.out.println("i=" + i + ", 重复列表" + repetition + ",list size=" + list.size());
        }


    }
}
