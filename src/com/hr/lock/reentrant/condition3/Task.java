package com.hr.lock.reentrant.condition3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/6/7 0007.
 */
public class Task {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    private boolean flag;

    public void product(){
        try {
            lock.lock();
            System.out.println("product");
            while (!flag){
                condition.await();
            }
            flag = !flag;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void consume(){
        try {
            lock.lock();
            System.out.println("consume");
            while (flag){
                condition.await();
            }
            flag = !flag;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
