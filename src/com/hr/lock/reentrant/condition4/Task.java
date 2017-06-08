package com.hr.lock.reentrant.condition4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/6/7 0007.
 */
public class Task {

    private Lock lock;

    public Task(boolean isFair) {
        //公平锁和非公平锁
        //公平锁是按程序加锁顺序获得锁
        //非公平锁是竞争模式
        this.lock = new ReentrantLock(isFair);
    }

    public void m1(){
        try{
            lock.lock();
            Thread.sleep(1);
            System.out.println(Thread.currentThread().getName() + " get lock");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
          lock.unlock();
        }
    }
}
