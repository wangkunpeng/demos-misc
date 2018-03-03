package com.demos.misc1.completablefuture;

import java.util.Date;
import java.util.concurrent.CompletableFuture;

/**
 * @author kunpeng.wkp
 * @date 2017/08/21
 **/
public class CompleteFutureTest3 {

    private static class Client extends Thread {
        private CompletableFuture<Integer> future;

        Client(String threadName, CompletableFuture<Integer> future) {
            super(threadName);
            this.future = future;
        }

        @Override
        public void run() {
            try {
                System.out.println(this.getName() + ": " + future.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        final CompletableFuture<Integer> future = new CompletableFuture<>();

        new Client("Client1", future).start();
        new Client("Client2", future).start();

        System.out.println("waiting ... " + new Date());

        System.out.println();

        Thread.sleep(3000);

        System.out.println("begin ... " + new Date());
        future.complete(100);
        System.out.println("end ... " + new Date());

    }
}