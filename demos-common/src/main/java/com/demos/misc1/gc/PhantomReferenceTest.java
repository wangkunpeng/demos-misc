package com.demos.misc1.gc;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author kunpeng.wkp
 * @date 2017/09/22
 **/
public class PhantomReferenceTest {
    public static void main(String[] args) throws InterruptedException {

        Object referent = new Object();
        WeakReference<Object> weakRerference = new WeakReference<>(referent);
        referent = null;
        System.out.println(weakRerference.get());
        System.gc();
        /**
         * 一旦没有指向 referent 的强引用, weak reference 在 GC 后会被自动回收
         */
        System.out.println(weakRerference.get());

        Map<Object, Object> weakHashMap = new WeakHashMap<Object, Object>();
        Object key = new Object();
        Object value = new Object();
        weakHashMap.put(key, value);
        System.out.println(weakHashMap.containsValue(value));
        key = null;
        System.gc();
        /**
         * 等待无效 entries 进入 ReferenceQueue 以便下一次调用 getTable 时被清理
         */
        Thread.sleep(1000);
        System.out.println(weakHashMap.containsValue(value));

        referent = new Object();
        SoftReference<Object> softRerference = new SoftReference<Object>(referent);
        System.out.println(softRerference.get());
        referent = null;
        /**
         *  soft references 只有在 jvm OutOfMemory 之前才会被回收, 所以它非常适合缓存应用
         */
        System.gc();
        System.out.println(softRerference.get());

        referent = new Object();
        PhantomReference<Object> phantomReference = new PhantomReference<Object>(referent,
            new ReferenceQueue<Object>());
        System.out.println(phantomReference.get());
    }
}
