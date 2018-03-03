package com.demos.misc1.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.function.Supplier;


public class CompleteFutureTest7 {

    public static class MySupplier implements Supplier<Integer> {
        @Override
        public Integer get() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        }
    }


    public static class PlusOne implements Function<Integer, Integer> {
        @Override
        public Integer apply(Integer x) {
            return x + 1;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("12456,5656".split(",")[0]);
        ExecutorService exec = Executors.newSingleThreadExecutor();

        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(new MySupplier(), exec);
        System.out.println(f1.isDone());

        //下面就可以看到，f2这个异步事件处理无缝引用了f这个异步事件处理的结果.整个过程中间不需要像future.get()这样引入了不必要的同步阻塞
        CompletableFuture<Integer> f2 = f1.thenApply(new PlusOne());

        System.out.println(f2.get()); // Waits until the "calculation" is done, then prints 2
    }
}