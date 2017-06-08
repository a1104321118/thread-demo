package com.hr.lock.reentrant.readwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Administrator on 2017/6/7 0007.
 */
public class Task {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void readlock(){
        try {
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + "get read lock");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }

    }

    public void writelock(){
        try {
            lock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "get write lock");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }

    }
}
