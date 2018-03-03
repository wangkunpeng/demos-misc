package com.demos.misc1.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;


/**
 * @author kunpeng.wkp
 * @date 2017/08/25
 **/
public class CompleteFutureTest4 {

    public static void main(String[] args) {

        CompletableFuture<Double> futurePrice = getPriceAsync();

        //do anything you want, 当前线程不被阻塞
        System.out.println("1 ...... ");

        //线程任务完成的话，执行回调函数，不阻塞后续操作
        futurePrice.whenComplete((aDouble, throwable) -> {
            System.out.println("complete  operation  -----> " + aDouble);
        });

        System.out.println("2 ......");
    }


    static class ConsumerP<Double> implements Consumer {

        @Override
        public void accept(Object o) {

        }

        @Override
        public Consumer andThen(Consumer after) {
            return null;
        }
    }


    static CompletableFuture<Double> getPriceAsync() {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();

        new Thread(() -> {
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            futurePrice.complete(23.55);
        }).start();

        return futurePrice;
    }
}