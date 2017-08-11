package com.hr.juc.util;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * CyclicBarrier 同步屏障
 * 初始化时有个计数器
 * 每次调用 await() 的时候，表示已经到达屏障，计数-1
 * 当计数为0的时候，统一放行
 *
 * 适用于多线程计算数据，最后合并计算结果的模型
 */
public class CyclicBarrierTest {

    static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                try {
                    TimeUnit.SECONDS.sleep(2);
                    c.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(5);
            }
        }).start();

        try {
            System.out.println(2);
            c.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(3);
    }
}
