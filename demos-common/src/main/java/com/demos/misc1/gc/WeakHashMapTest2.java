package com.demos.misc1.gc;

/**
 * @author kunpeng.wkp
 * @date 2017/12/30
 **/

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapTest2 {
    public static void main(String[] args) throws Exception {
        String a = new String("a");
        String b = new String("b");

        Map weakmap = new WeakHashMap();
        weakmap.put(a, "aaa");
        weakmap.put(b, "bbb");

        Map map = new HashMap();
        map.put(a, "aaa");
        map.put(b, "bbb");

        map.remove(a);

        a = null;
        b = null;

        System.gc();
        Iterator i = map.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry en = (Map.Entry)i.next();
            System.out.println("map:" + en.getKey() + ":" + en.getValue());
        }

        Iterator j = weakmap.entrySet().iterator();
        while (j.hasNext()) {
            Map.Entry en = (Map.Entry)j.next();
            System.out.println("weakmap:" + en.getKey() + ":" + en.getValue());
        }
    }
}