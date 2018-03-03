package com.demos.misc1.threadlocaltest;

/**
 * @author kunpeng.wkp
 * @date 2017/10/25
 **/
public class Threadlocaltest {

    private static ThreadLocal tl = new ThreadLocal<String>();

    public static void main(String[] args) {

        if (tl.get() == null) {
            tl.set("1");
        }
        System.out.println(tl.get());

        tl.set("2");
        System.out.println(tl.get());
    }
}