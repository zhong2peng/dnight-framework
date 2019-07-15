package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author ZHONGPENG769
 * @date 2019/7/11
 */
public class Atomic1 {
    private static final int NUM_INCREMENTS = 1000;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    private static void testUpdate() {
        atomicInteger.set(0);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        IntStream.range(0, NUM_INCREMENTS).forEach(i -> {
            Runnable task = () -> atomicInteger.updateAndGet(n -> n + 2);
            executorService.submit(task);
        });
        ConcurrentUtils.stop(executorService);
        System.out.format("Update: %d\n", atomicInteger.get());
    }

    private static void testAccumulate() {
        atomicInteger.set(0);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        // 计算 0~999 所有数字的和
        IntStream.range(0, NUM_INCREMENTS).forEach(
                i -> {
                    Runnable task = () -> atomicInteger.accumulateAndGet(i, (n, m) -> n + m);
                    executorService.submit(task);
                }
        );
        ConcurrentUtils.stop(executorService);
        System.out.printf("Accumulate: %d\n", atomicInteger.get());
    }

    private static void testIncrement() {
        atomicInteger.set(0);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        IntStream.range(0, NUM_INCREMENTS).forEach(
                i -> executorService.submit(atomicInteger::incrementAndGet)
        );
        ConcurrentUtils.stop(executorService);
        System.out.printf("Increment: Expected=%d, Is=%d\n", NUM_INCREMENTS, atomicInteger.get());
    }

    public static void main(String[] args) {
        testAccumulate();
        testIncrement();
        testUpdate();
    }


}
