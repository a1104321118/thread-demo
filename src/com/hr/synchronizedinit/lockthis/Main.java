package com.hr.synchronizedinit.lockthis;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
public class Main {

    public static void main(String[] args) {
        Task task = new Task();
        MyThread m1 = new MyThread(task);
        MyThread2 m2 = new MyThread2(task);
        MyThread3 m3 = new MyThread3(task);

        //锁对象，即使访问一个对象的两个不同的 synchronize 方法，因为对象被锁了，所以也只能等待对象释放锁
        m1.start();
        m2.start();

        //但是异步方法不受影响（不需要锁）
        m3.start();

    }
}
