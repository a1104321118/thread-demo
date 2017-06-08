package com.hr.lock.reentrant.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/6/7 0007.
 */
public class Task {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void await(){
        try {
            lock.lock();
            condition.await(); //类似于 wait()
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
            System.out.println("await unlock");
        }
    }

    public void signal(){
        try {
            lock.lock();
            condition.signal(); //类似于 notify(),但是要自己 unlock
        } finally {
            lock.unlock();
            System.out.println("signal unlock");
        }
    }
}
