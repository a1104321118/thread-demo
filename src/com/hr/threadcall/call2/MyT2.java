package com.hr.threadcall.call2;

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
            for (int i = 0; i < 10; i++) {
                if(i == 5){
                    lock.notify(); //notify 不会释放锁，只是唤醒 以前持有 lock 锁的，在wait 中的线程
                    System.out.println("iiiiiiiiiiiiiiiiiiiiiiii");
                }
                System.out.println("myt2 i=" + i);
            }
            System.out.println("myt2 notify end");
        }
    }
}
