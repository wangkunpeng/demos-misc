package com.demos.misc1.stream.basic;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author kunpeng.wkp
 * @date 2017/09/05
 **/
public class Basic1 {

    public static void main(String[] args) {
        System.out.println(Collections.emptyMap());

        Collection collection;
        Map map;
        Set set;
        List list;
        HashMap hashMap;

        ConcurrentHashMap concurrentHashMap;
        String ss="{\"include\":{\"P1\":[\"DB\",\"LOG\"],\"P2\":[\"LOG\"]},\"exclude\":[{\"source\":\"1\",\"subSource\":\"1\"},{\"source\":\"2\",\"subSource\":\"22\"}]}";
    }
}
