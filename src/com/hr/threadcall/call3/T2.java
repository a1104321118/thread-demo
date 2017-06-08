package com.hr.threadcall.call3;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
public class T2 implements Runnable{

    private Object lock;

    public T2(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            System.out.println("begin T2");
            try {
                lock.wait();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("end T2");

        }
    }
}
