package com.hr.synchronizedinit.lockother;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
public class MyT2 implements Runnable{

    private Task task;

    public MyT2(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        try {
            task.m2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
