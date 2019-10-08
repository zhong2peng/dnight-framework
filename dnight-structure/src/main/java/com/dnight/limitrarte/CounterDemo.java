package com.dnight.limitrarte;

/**
 * @author ZHONGPENG769
 * @date 2019/10/8
 */
public class CounterDemo {

    public long timeStamp = System.currentTimeMillis();
    public int reqCount = 0;
    public final int limit = 100;
    public final long interval = 1000;

    /**
     * 计数器法：
     * 算法简单，但有临界问题
     * 在0：59，瞬间发送了100个请求，在1：00又瞬间发送了100个请求
     * 在1s内，瞬间发送了200个请求，规定1分钟内最多100个请求，可利用临界值瞬间压垮应用
     * 可用滑动窗口优化这个方案，1分钟内划分成6个格子，每个格子有独立的计数器，格子越多限流统计越精确
     *
     * @return
     */
    public boolean grant() {
        long now = System.currentTimeMillis();
        if (now < timeStamp + interval) {
            reqCount++;
            return reqCount <= limit;
        } else {
            timeStamp = now;
            reqCount = 1;
            return true;
        }
    }
}
