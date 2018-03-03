package com.demos.misc1.extendclass;

/**
 * @author kunpeng.wkp
 * @date 2017/10/18
 **/
public class Child extends Basic {
    private int field2;

    public int getField2() {
        return field2;
    }

    public void setField2(int field2) {
        this.field2 = field2;
    }

    public Child(int field2) {
        this.field2 = field2;
    }

    protected void wangwang() {
        System.out.println("wang wang wang 2 ===== ");
    }

    protected void hello() {
        super.wangwang();
    }

    public static void main(String[] args) {
        Child c = new Child(1);

        System.out.println(c.getField1());
        System.out.println(c.getField2());

        c.hello();

    }
}
