package com.hr.threadcall.call3;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
public class T1 implements Runnable{

    private Object lock;

    public T1(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            System.out.println("begin T1");
            try {
                lock.wait(); //执行到这里就不会往下执行了，当notifyAll的时候，所有wait中的线程会 竞争锁
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("end T1");

        }
    }
}
