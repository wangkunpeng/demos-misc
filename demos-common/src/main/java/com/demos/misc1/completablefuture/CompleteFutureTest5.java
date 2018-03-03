package com.demos.misc1.completablefuture;

import java.util.concurrent.*;
import java.util.function.Consumer;

/**
 * @author kunpeng.wkp
 * @date 2017/08/25
 **/
public class CompleteFutureTest5 {

    private static class RunClass<Long> implements Callable {
        @Override
        public Object call() throws Exception {
            Thread.sleep(1000);
            return System.currentTimeMillis() / 1000;
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

    private static class RunTask<Long> implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(System.currentTimeMillis() / 1000);
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Semaphore semaphore = new Semaphore(4);
        ExecutorService executor = Executors.newFixedThreadPool(100);

        for (int index = 0; index < 100; index++) {
            RunTask runTask = new RunTask();
            CompletableFuture<Void> future = CompletableFuture.runAsync(runTask, executor);
            ControlConsumer controlConsumer = new ControlConsumer();
            future.thenAccept(controlConsumer);


        }

    }
}