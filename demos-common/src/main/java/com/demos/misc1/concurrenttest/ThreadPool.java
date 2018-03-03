package com.demos.misc1.concurrenttest;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author kunpeng.wkp
 * @date 2017/08/01
 **/

public class ThreadPool {

    //让可执行程序休息一下
    private static int executePrograms = 0;
    private static int produceTaskMaxNumber = 30;

    public static void main(String[] args) {
        // 构造一个线程池
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 1, 3, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(1), new ThreadPoolExecutor.CallerRunsPolicy());

        long bg = System.currentTimeMillis();
        for (int i = 1; i <= produceTaskMaxNumber; i++) {
            try {
                String task = "task@ " + i;
                System.out.println("put " + task);
                threadPool.execute(new ThreadPoolTask(task));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        long ed = System.currentTimeMillis();
        System.out.println((ed - bg) + " ms ");
    }

    ScheduledExecutorService scheduledExecutorService;

    ConcurrentLinkedQueue concurrentLinkedQueue;

    ConcurrentLinkedDeque concurrentLinkedDeque;

    CountDownLatch countDownLatch;

    AtomicInteger atomicInteger;
}
