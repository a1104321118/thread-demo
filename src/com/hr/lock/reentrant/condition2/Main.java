package com.hr.lock.reentrant.condition2;

/**
 * Created by Administrator on 2017/6/7 0007.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        Thread t1 = new Thread(new T1(task));
        Thread t2 = new Thread(new T2(task));

        t1.start();
        t2.start();

        Thread.sleep(10000);
        task.signalA();//分离控制，只唤醒 conditionA 的等待线程
    }
}
