package com.hr.threadcall.call3;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread t1 = new Thread(new T1(lock));
        Thread t2 = new Thread(new T2(lock));
        Thread t3 = new Thread(new T3(lock));
        t1.start();
        t2.start();
        Thread.sleep(1000);
        t3.start();
//        IllegalMonitorStateException 抛出场景，总而言之，当当前线程没该对象锁的时候，强行调用 wait/notify等方法
//        1>当前线程不含有当前对象的锁资源的时候，调用obj.wait()方法;
//        2>当前线程不含有当前对象的锁资源的时候，调用obj.notify()方法。
//        3>当前线程不含有当前对象的锁资源的时候，调用obj.notifyAll()方法

    }
}
