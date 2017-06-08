package com.hr.synchronizedinit.lockthis;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
public class MyThread extends Thread{

    private Task task;

    public MyThread(Task task){
        this.task = task;
    }

    @Override
    public void run() {
        super.run();
        try {
            task.m1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
