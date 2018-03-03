package com.demos.misc1.asm.cc;

import java.lang.reflect.Array;

/**
 * @author kunpeng.wkp
 * @date 2017/12/20
 **/
public class Node<DATATYPE> {
    private DATATYPE data;

    private Class<DATATYPE> type;

    public Node(DATATYPE data, Class<DATATYPE> type) {
        this.data = data;
        this.type = type;
    }

    public void setData(DATATYPE data) {
        System.out.println("Node.setData");
        this.data = data;
    }

    public void printData(DATATYPE... datas) {
        for (DATATYPE data : datas) {
            System.out.println(data);
        }
    }

    public DATATYPE[] createArrayData(int size) {
        return (DATATYPE[])Array.newInstance(type, size);
    }
}
