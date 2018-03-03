package com.demos.misc1.genetic;

/**
 * @author kunpeng.wkp
 * @date 2017/10/18
 **/
public class BasicGen2<K, V, Q, S, SS> {
    private K key;
    private V value;
    private Q qq;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Q getQq() {
        return qq;
    }

    public void setQq(Q qq) {
        this.qq = qq;
    }

    public BasicGen2(K key, V value, Q qq) {
        this.key = key;
        this.value = value;
        this.qq = qq;
    }

    public BasicGen2() {
    }
}
