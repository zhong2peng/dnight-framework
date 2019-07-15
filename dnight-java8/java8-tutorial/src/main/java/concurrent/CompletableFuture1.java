package concurrent;

import java.util.concurrent.CompletableFuture;

/**
 * @author ZHONGPENG769
 * @date 2019/7/15
 */
public class CompletableFuture1 {

    /**
     * 异步调用其实就是实现一个可无需等待被调用函数的返回值而让操作继续运行的方法。
     * 在 Java 语言中，简单的讲就是另启一个线程来完成调用中的部分计算，使调用继续运行或返回，而不需要等待计算结果。
     * 但调用者仍需要取线程的计算结果。
     * <p>
     * JDK5新增了Future接口，用于描述一个异步计算的结果。虽然 Future 以及相关使用方法提供了异步执行任务的能力，
     * 但是对于结果的获取却是很不方便，只能通过阻塞或者轮询的方式得到任务的结果。
     * 阻塞的方式显然和我们的异步编程的初衷相违背，轮询的方式又会耗费无谓的 CPU 资源，而且也不能及时地得到计算结果。
     * <p>
     * Future接口可以构建异步应用，但依然有其局限性。它很难直接表述多个Future 结果之间的依赖性。
     * 实际开发中，我们经常需要达成以下目的：
     * 将多个异步计算的结果合并成一个
     * 等待Future集合中的所有任务都完成
     * Future完成事件（即，任务完成以后触发执行动作）
     * <p>
     * 在Java8中，CompletableFuture提供了非常强大的Future的扩展功能，可以帮助我们简化异步编程的复杂性，
     * 并且提供了函数式编程的能力，可以通过回调的方式处理计算结果，也提供了转换和组合 CompletableFuture 的方法。
     * 它可能代表一个明确完成的Future，也有可能代表一个完成阶段（ CompletionStage ），
     * 它支持在计算完成以后触发一些函数或执行某些动作。
     * 它实现了Future和CompletionStage接口
     * <p>
     * 可以看到，thenAccept和thenRun都是无返回值的。如果说thenApply是不停的输入输出的进行生产，那么thenAccept和thenRun就是在进行消耗。它们是整个计算的最后两个阶段。
     * 同样是执行指定的动作，同样是消耗，二者也有区别：
     * thenAccept接收上一阶段的输出作为本阶段的输入
     * thenRun根本不关心前一阶段的输出，根本不不关心前一阶段的计算结果，因为它不需要输入参数
     */
    public static void main(String[] args) {
        CompletableFuture<String> future = new CompletableFuture<>();
        future.complete("42");
        future.thenAccept(System.out::println).thenAccept(i -> {
            System.out.println("done");
        });
    }
}
