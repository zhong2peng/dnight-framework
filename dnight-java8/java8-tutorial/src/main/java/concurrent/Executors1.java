package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author ZHONGPENG769
 * @date 2019/7/15
 */
public class Executors1 {

    public static void main(String[] args) {
        test1(3);
    }

    private static void test1(long seconds) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(seconds);
                String name = Thread.currentThread().getName();
                System.out.println("task finished: ");
            } catch (InterruptedException e) {
                System.out.println("task interrupted");
            }
        });
        stop(executorService);
    }

    static void stop(ExecutorService executorService) {
        System.out.println("attempt to shutdown executor");
        executorService.shutdown();
        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("termination interrupted");
        } finally {
            if (!executorService.isTerminated()) {
                System.out.println("killing non-finished tasks");
            }
            executorService.shutdownNow();
            System.out.println("shutdown finished");
        }

    }
}
