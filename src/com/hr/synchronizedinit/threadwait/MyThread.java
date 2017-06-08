package com.hr.synchronizedinit.threadwait;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
public class MyThread implements Runnable{
    @Override
    public void run() {
        try {
            System.out.println("thread begin");
            Thread.sleep(3000);
            System.out.println("thread end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
