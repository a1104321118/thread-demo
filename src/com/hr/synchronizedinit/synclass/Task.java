package com.hr.synchronizedinit.synclass;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
public class Task {

    public void m1() throws InterruptedException {
        synchronized (Task.class){
            System.out.println("m1");
            Thread.sleep(1000);
        }
    }
}
