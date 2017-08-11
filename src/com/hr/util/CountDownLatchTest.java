package com.hr.util;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch 是juc包中的一个阻塞工具
 * 初始化提供一个计数值
 * 每次调用 countDown() 的时候，计数-1
 * 调用await()的时候会阻塞当前线程，直到计数为0
 */
public class CountDownLatchTest {

    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(111);
                c.countDown();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(222);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                c.countDown();
            }
        }).start();

        try {
            //阻塞主线程，直到计数为0
            c.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(3);


    }
}
