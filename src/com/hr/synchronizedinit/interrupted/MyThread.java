package com.hr.synchronizedinit.interrupted;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
public class MyThread implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("被打断了");
            e.printStackTrace();
        }
    }
}
