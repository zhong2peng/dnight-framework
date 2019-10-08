package com.dnight.limitrarte;

/**
 * @author ZHONGPENG769
 * @date 2019/10/8
 */
public class LeakyDemo {

    public long timeStamp = System.currentTimeMillis();
    public int capacity; //桶的容量
    public int rate; //水漏出的速度
    public int water; //当前水量

    /**
     * 漏桶算法：
     * 有一个固定容量的桶，有水流进来，也有水流出去。
     * 对于流进来的水，无法预计有多少，也无法预计水流的速度
     * 对于流出去的水，桶可以固定水流出的速率，当桶满了之后，多余的水会溢出
     * 水换成实际应用中的请求
     *
     * @return
     */
    public boolean grant() {
        long now = System.currentTimeMillis();
        // 执行漏水，计算剩余容量
        water = (int) Math.max(0, water - (now - timeStamp) * rate);
        timeStamp = now;
        // 尝试加水，水还未满
        if ((water + 1) < capacity) {
            water += 1;
            return true;
        } else {
            return false;
        }
    }
}
