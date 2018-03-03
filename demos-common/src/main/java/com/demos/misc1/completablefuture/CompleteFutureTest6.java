package com.demos.misc1.completablefuture;

import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author kunpeng.wkp
 * @date 2017/08/25
 **/
public class CompleteFutureTest6 {

    private static class RunRun implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    private static class ControlConsumer implements Consumer<Void> {
        private Semaphore semaphore = new Semaphore(4);

        @Override
        public void accept(Void msg) {
            this.semaphore.release(1);
            System.out.println("this is msg ... ");
        }
    }

    private static class RunTask implements Supplier<String> {

        private String hello() {
            return System.currentTimeMillis() + "";
        }

        @Override
        public String get() {
            System.out.println("----- ===== ------");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return hello();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Semaphore semaphore = new Semaphore(2);
        ExecutorService executor = Executors.newFixedThreadPool(5);

        System.out.println(ForkJoinPool.commonPool().getParallelism());

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 100;
        }, executor);
        CompletableFuture<Void> f = future.thenAccept(System.out::println);
        System.out.println("----> " + f.get());

        for (int index = 0; index < 10; index++) {
            CompletableFuture<Void> ff = CompletableFuture.runAsync(new RunRun(), executor);
        }

    }
}