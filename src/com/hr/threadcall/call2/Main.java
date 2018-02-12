package com.hr.threadcall.call2;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
public class Main {

    public static void main(String[] args) {
        Object lock = 0;
        Thread t1 = new Thread(new MyT1(lock));
        Thread t2 = new Thread(new MyT2(lock));

        //当 notify 方法所在的同步块执行完之后，才会执行 wait 原来所在的方法块
        t1.start();
        try {
            Thread.sleep(1000);//确保t1 先执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
