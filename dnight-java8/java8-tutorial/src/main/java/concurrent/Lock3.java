package concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author ZHONGPENG769
 * @date 2019/7/15
 */
public class Lock3 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Map<String, String> map = new HashMap<>();
        ReadWriteLock lock = new ReentrantReadWriteLock();
        executorService.submit(() -> {
            lock.writeLock().lock();
            ConcurrentUtils.sleep(1);
            map.put("foo", "bar");
            lock.writeLock().unlock();
        });

        Runnable readTask = () -> {
            lock.readLock().lock();
            System.out.println("foo");
            ConcurrentUtils.sleep(1);
            lock.readLock().unlock();
        };
        executorService.submit(readTask);
        executorService.submit(readTask);
        ConcurrentUtils.stop(executorService);
    }
}
