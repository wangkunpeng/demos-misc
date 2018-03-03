package com.demos.misc1.asm.cc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kunpeng.wkp
 * @date 2017/12/20
 **/
public class MyNode extends Node<Integer> {

    public MyNode(Integer data) {
        super(data, Integer.class);
    }

    public void setData(Integer data) {
        System.out.println("MyNode.setData");
        super.setData(data);
    }

    public static void main(String[] args) {

        MyNode myNode = new MyNode(1);

        Node n = myNode; // A raw type - compiler throws an unchecked warning
        //n.setData("Hello");

        List list = new ArrayList<String>();
        list.add("1");
        list.add(4);
        list.add("5");

        Integer[] integers = new Integer[2];
        integers[0] = 1;
        integers[1] = 2;

        List ints = new ArrayList<Integer>();
        ints.add(1);
        ints.add(2);
        //myNode.printData(ints);

    }
}
