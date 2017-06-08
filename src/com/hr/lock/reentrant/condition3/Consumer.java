package com.hr.lock.reentrant.condition3;

/**
 * Created by Administrator on 2017/6/7 0007.
 */
public class Consumer implements Runnable{

    private Task task;

    public Consumer(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {

            task.consume();
        }
    }
}
