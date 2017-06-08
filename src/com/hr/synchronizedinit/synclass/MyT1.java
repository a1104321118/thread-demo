package com.hr.synchronizedinit.synclass;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
public class MyT1 implements Runnable{

    private Task task;

    public MyT1(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        try {
            task.m1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
