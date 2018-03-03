package com.demos.misc1.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author kunpeng.wkp
 * @date 2017/08/21
 **/
public class CompleteFutureTest2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = new CompletableFuture();
        System.out.println(future.complete(100));
        //System.out.println(future.completeExceptionally(new Exception()));
        System.out.println(future.get());
    }
}