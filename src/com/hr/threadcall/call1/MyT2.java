package com.hr.threadcall.call1;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
public class MyT2 implements Runnable{

    private Object lock;

    public MyT2(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            System.out.println("myt2 notify");
            lock.notify();
            System.out.println("myt2 notify end");
        }
    }
}
