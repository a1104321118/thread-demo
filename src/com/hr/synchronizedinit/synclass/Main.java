package com.hr.synchronizedinit.synclass;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
public class Main {

    public static void main(String[] args) {
        Task t1 = new Task();
        Task t2 = new Task();

        //不同对象，但是锁的是 class ，对所有对象实例都有效（t1 和 t2）
        Thread thread1 = new Thread(new MyT1(t1));
        Thread thread11 = new Thread(new MyT1(t1));
        Thread thread2 = new Thread(new MyT1(t2));

        thread1.start();
        thread11.start();
        thread2.start();
    }
}
