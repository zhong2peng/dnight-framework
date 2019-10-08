package com.dnight.limitrarte;

/**
 * @author ZHONGPENG769
 * @date 2019/10/8
 */
public class TokenBucketDemo {

    public long timeStamp = System.currentTimeMillis();
    public int capacity;
    public int rate;
    public int tokens;

    public boolean grant() {
        long now = System.currentTimeMillis();
        tokens = (int) Math.min(capacity, tokens + (now - timeStamp) * rate);
        timeStamp = now;
        if (tokens < 1) {
            return false;
        } else {
            tokens -= 1;
            return true;
        }
    }
}
