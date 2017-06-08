package com.hr.lock.reentrant.condition2;

/**
 * Created by Administrator on 2017/6/7 0007.
 */
public class T2 implements Runnable{

    private Task task;

    public T2(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        task.awaitB();
    }
}
