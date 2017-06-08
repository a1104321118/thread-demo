package com.hr.lock.reentrant.condition;

/**
 * Created by Administrator on 2017/6/7 0007.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        Thread thread = new Thread(new T1(task));

        thread.start();
        Thread.sleep(200);
        task.signal();
    }
}
