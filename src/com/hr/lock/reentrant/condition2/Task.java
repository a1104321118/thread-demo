package com.hr.lock.reentrant.condition2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/6/7 0007.
 */
public class Task {

    // lock + condition 相当于以前的 lockObj，只是更加细粒度,把锁操作和其它操作分离，控制上也更加细粒度
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();

    public void awaitA(){
        try {
            lock.lock();
            System.out.println("conditionA await");
            conditionA.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("conditionA unAwait");
            lock.unlock();
        }
    }

    public void awaitB(){
        try {
            lock.lock();
            System.out.println("conditionB await");
            conditionB.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("conditionB unAwait");
            lock.unlock();
        }
    }

    public void signalA(){
        try {
            lock.lock();
            conditionA.signalAll(); //分离控制，只唤醒 conditionA 的等待线程
            System.out.println("conditionA signal");
        } finally {
            lock.unlock();
        }
    }

    public void signalB(){
        try {
            lock.lock();
            conditionB.signalAll();
            System.out.println("conditionB signal");
        } finally {
            lock.unlock();
        }
    }
}
