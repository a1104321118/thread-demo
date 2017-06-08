package com.hr.synchronizedinit.lockthis;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
public class Task {

    public synchronized void m1() throws InterruptedException {
        System.out.println("m1");
        Thread.sleep(1000);
    }

    public synchronized void m2() throws InterruptedException {
        System.out.println("m2");
        Thread.sleep(1000);
    }
    public void m3() throws InterruptedException {
        System.out.println("m3");
        Thread.sleep(1000);
    }

}
