package com.demos.misc1.extendclass;

/**
 * @author kunpeng.wkp
 * @date 2017/10/18
 **/
public abstract class Basic {
    private int field1;

    public Basic(int field1) {
        this.field1 = field1;
    }

    public int getField1() {
        return field1;
    }

    public void setField1(int field1) {
        this.field1 = field1;
    }

    public Basic() {
    }

    protected void wangwang() {
        System.out.println("wang wang 1 ==== ");
    }

    protected void hello() {
        this.wangwang();
    }
}


