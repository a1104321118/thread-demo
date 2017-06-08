package com.hr.threadcall.call1;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
public class MyT1 implements Runnable{

    private Object lock;

    public MyT1(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            System.out.println("Myt1 wait");
            try {
                lock.wait(); //wait 会让该线程释放锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("MyT1 wait end");
        }
    }
}
