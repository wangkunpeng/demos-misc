package com.demos.misc1.volitaletest;

import java.util.HashMap;

/**
 * @author kunpeng.wkp
 * @date 2017/10/27
 **/
public class UpdateThread implements Runnable {

    private HashMap<String, String> map = new HashMap();

    public Long data = 0L;


    public UpdateThread(HashMap<String, String> map) {
        this.map = map;
    }

    public UpdateThread() {
    }

    public HashMap<String, String> getMap() {
        return map;
    }

    public void setMap(HashMap<String, String> map) {
        this.map = map;
    }


    public Long getData() {
        return data;
    }

    public void setData(Long data) {
        this.data = data;
    }

    @Override
    public void run() {
        while (true) {
            map = new HashMap();
            map.put(System.nanoTime() + "", System.nanoTime() + "");
            data = System.currentTimeMillis();
            try {
                Thread.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
