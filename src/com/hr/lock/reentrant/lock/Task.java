package com.hr.lock.reentrant.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/6/7 0007.
 */
public class Task {

    private Lock lock = new ReentrantLock();

    public void m1(){
        lock.lock();//占有锁
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
        }
        lock.unlock();
    }
}
