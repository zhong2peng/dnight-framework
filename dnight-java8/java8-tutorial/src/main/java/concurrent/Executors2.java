package concurrent;

import java.util.concurrent.*;

/**
 * @author ZHONGPENG769
 * @date 2019/7/15
 */
public class Executors2 {

    private static void test3() {
//        ExecutorService executorService = Executors.newFixedThreadPool(1);
//        Future<Integer> future = executorService.submit(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(2);
//                return 123;
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        future.get(1, TimeUnit.SECONDS);

        ExecutorService executor = Executors.newFixedThreadPool(1);

        Future<Integer> future = executor.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                return 123;
            } catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        });

        try {
            future.get(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    private static void test2() {
//        ExecutorService executorService = Executors.newFixedThreadPool(1);
//        Future<Integer> future = executorService.submit(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//                return 123;
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        executorService.shutdownNow();
//        future.get();
        ExecutorService executor = Executors.newFixedThreadPool(1);

        Future<Integer> future = executor.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return 123;
            } catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        });

        executor.shutdownNow();
        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void test1() {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        Future<Integer> future = executor.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return 123;
            } catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        });

        System.out.println("future done: " + future.isDone());

        try {
            Integer result = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
}
