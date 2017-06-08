package com.hr.lock.reentrant.condition4;

/**
 * Created by Administrator on 2017/6/7 0007.
 */
public class Main {

    public static void main(String[] args) {
        Task task = new Task(true);

        //Task task = new Task(false);

        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new T1(task),"thread" + i);
            threads[i].start();
        }

    }
}
