package com.hr.util;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Exchanger 线程数据交换者，适用于两个线程
 *
 * 一个调用exchange() 的时候，发送数据并进行阻塞等待
 * 如果有另一个线程调用exchange() 的时候，双方开始交换数据
 */
public class ExchangerTest {

    static final Exchanger<String> e = new Exchanger<>();

    static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                String A = "A";
                try {
                    String exchange = e.exchange(A);
                    System.out.println("A收到的数据:" + exchange);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                String B = "B";
                try {
                    TimeUnit.SECONDS.sleep(1);
                    String exchange = e.exchange(B);
                    System.out.println("B收到的数据:" + exchange);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }

            }
        });

        threadPool.shutdown();
    }
}
