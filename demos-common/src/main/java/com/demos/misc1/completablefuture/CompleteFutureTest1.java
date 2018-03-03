package com.demos.misc1.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author kunpeng.wkp
 * @date 2017/08/21
 **/
public class CompleteFutureTest1 {

    private static ExecutorService executor = Executors.newFixedThreadPool(4);
    //Supplier;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //CompletableFuture future = CompletableFuture.supplyAsync(() -> {
        //    System.out.println("CompletableFuture test1 ... ");
        //    return 100;
        //}, executor);

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("CompletableFuture test1 ... ");
            return 100;
        });
        System.out.println(future.get());
    }
}