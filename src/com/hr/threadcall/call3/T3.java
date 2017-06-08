package com.hr.threadcall.call3;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
public class T3 implements Runnable{

    private Object lock;

    public T3(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            System.out.println("begin T3");
            //lock.notify();//只能唤醒一个
            lock.notifyAll();
            System.out.println("end T3");
        }
    }
}
