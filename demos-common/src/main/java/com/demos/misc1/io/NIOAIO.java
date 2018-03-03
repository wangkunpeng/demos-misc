package com.demos.misc1.io;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.channels.spi.SelectorProvider;

/**
 * @author kunpeng.wkp
 * @date 2017/12/31
 **/
public class NIOAIO {

    public static void main(String[] args) throws IOException {
        NullPointerException exception;

        Selector selector;

        SelectorProvider selectorProvider = null;

        //selectorProvider.openSelector().provider();

        ThreadLocal threadLocal;

        System.out.println("123_456".split("_")[0]);

    }
}
