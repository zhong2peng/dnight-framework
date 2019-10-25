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

    /**
     * 令牌桶和漏桶颇有几分相似，只不过令牌通里存放的是令牌。它的运行过程是这样的，一个令牌工厂按照设定值定期向令牌桶发放令牌。
     * 当令牌桶满了后，多出的令牌会被丢弃掉。每当一个请求到来时，该请求对应的线程会从令牌桶中取令牌。
     * 初期由于令牌桶中存放了很多个令牌，因此允许多个请求同时取令牌。
     * 当桶中没有令牌后，无法获取到令牌的请求可以丢弃，或者重试。
     * <p>
     * 尽管令牌桶允许突发流量，但突发流量速率 R1 + 限流速率 R2 不能超过系统最大的处理能力 Rt，
     * 即 R1 + R2 ≤ Rt,否则会冲垮系统。
     *
     * @return
     */
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
