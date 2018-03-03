package com.demos.misc1.gc;

/**
 * @author kunpeng.wkp
 * @date 2017/12/30
 **/

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapTest1 {

    static Map wMap = new WeakHashMap();

    public static void init() {
        wMap.put("1", "ding");
        wMap.put("2", "job");
    }

    public static void testWeakHashMap() {
        System.out.println("first get:" + wMap.get("1"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("next get:" + wMap.get("1"));
    }

    public static void main(String[] args) {
        WeakHashMapTest1.init();
        testWeakHashMap();
        testWeakHashMap();
        testWeakHashMap();
    }
}
