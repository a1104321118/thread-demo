package com.hr.lock.reentrant.lockmethod;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/6/7 0007.
 */
public class Task {

    private ReentrantLock lock = new ReentrantLock();

    public void m1(){
        try{
            lock.lock();
            System.out.println("m1 getHoldCount()=" + lock.getHoldCount());
            m2();
        }finally {
            lock.unlock();
            System.out.println("after unlock m1 getHoldCount()=" + lock.getHoldCount());
        }
    }

    public void m2(){
        try{
            lock.lock();
            System.out.println("m2 getHoldCount()=" + lock.getHoldCount());
        }finally {
            lock.unlock();
            System.out.println("after unlock m2 getHoldCount()=" + lock.getHoldCount());
        }
    }

    public void reentrantMethod(){

        lock.getQueueLength();//正在等待获取该锁的线程数
        lock.getWaitQueueLength(lock.newCondition()); //比上面多了个 condition
        lock.hasQueuedThread(new Thread()); //判断该线程是不是正在等待这个锁
        lock.hasWaiters(lock.newCondition()); //查询该锁是否存在该条件
        lock.hasQueuedThreads();//查询是否有线程在等待此锁

        lock.isFair();
        lock.isHeldByCurrentThread();
        lock.isLocked();

        try {
            lock.lockInterruptibly();//如果当前线程未被中断，则获取锁，否则抛异常
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock.tryLock();
        try {
            lock.tryLock(100, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock.newCondition().awaitUninterruptibly();//不允许打断的等待，即interrupt() 无效

        try {
            lock.newCondition().awaitUntil(new Date());//在 指定时间唤醒自己，类似于 Thread.sleep()?
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
