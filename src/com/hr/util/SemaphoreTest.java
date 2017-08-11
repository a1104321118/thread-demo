package com.hr.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Semaphore 控制并发线程数
 * 初始化时，要规定许可证的数量
 * 调用 acquire() 的时候，会获取许可证
 * 调用 release() 的时候，或归还许可证
 */
public class SemaphoreTest {

    static final int THREAD_HOLD = 30;

    static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_HOLD);

    static Semaphore s = new Semaphore(10);

    public static void main(String[] args) {
        for (int i=0; i<THREAD_HOLD; i++){
            final int finalI = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        s.acquire();
                        System.out.println(finalI);
                        TimeUnit.SECONDS.sleep(1);
                        s.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        threadPool.shutdown();
    }
}
