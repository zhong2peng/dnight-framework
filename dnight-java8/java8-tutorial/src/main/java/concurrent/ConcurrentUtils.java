package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author ZHONGPENG769
 * @date 2019/7/15
 */
public class ConcurrentUtils {

    public static void stop(ExecutorService executor) {
        executor.shutdown();
        try {
            executor.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("termination interrupted");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("killing non-fininshed tasks");
            }
            executor.shutdownNow();
        }
    }

    public static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
