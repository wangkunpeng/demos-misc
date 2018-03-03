package com.demos.misc1.asm.javabasic;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author kunpeng.wkp
 * @date 2017/12/25
 **/
public class ConcurrentBasic {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 10, 100, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<Runnable>(10));

        ExecutorService executors = Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newWorkStealingPool();

        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(10);

        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        HashMap hashMap = new HashMap<Integer, Integer>();

        Map map = new HashMap();

        WeakHashMap weakHashMap = new WeakHashMap();
        weakHashMap.put(1, 1);
        weakHashMap.put(2, 2);
        System.out.println("size is " + weakHashMap.size());
        weakHashMap.get(1);
        weakHashMap.get(2);
        System.gc();
        System.gc();
        System.gc();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after  gc ,size is " + weakHashMap.get(1));
    }
}
