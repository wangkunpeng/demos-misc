package com.demos.misc1.volitaletest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author kunpeng.wkp
 * @date 2017/10/27
 **/
public class MainThread {


    public static void main(String[] args) {

        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(8);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 4, 0, TimeUnit.MILLISECONDS, blockingQueue);

        UpdateThread updateThread = new UpdateThread();
        executor.submit(updateThread);

        while (true) {
            //System.out.println(updateThread.getMap());
            System.out.println(updateThread.getData());
            System.out.println(updateThread.data);
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
