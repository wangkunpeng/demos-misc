package com.demos.misc1.gc;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author kunpeng.wkp
 * @date 2017/12/30
 **/
public class WeakReferenceTest {
    public static void main(String[] args) throws Exception {
        Object o = new Object();

        ReferenceQueue queue = new ReferenceQueue();

        WeakReference weakReference = new WeakReference(o, queue);

        System.out.println("0---> " + o);

        System.out.println("1---> " + weakReference.get());

        System.out.println("2---> " + queue.poll());

        o = null;

        System.out.println("3---> " + weakReference.get());

        System.gc();

        //如果不进行slepp，下面的queue.poll() 方法就不能得到WeakReference对象
        Thread.sleep(3000);

        System.out.println("4---> " + queue.poll());

        System.out.println("5---> " + weakReference.get());

    }

}
