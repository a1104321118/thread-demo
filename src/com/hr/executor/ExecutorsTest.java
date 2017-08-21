package com.hr.executor;

import java.util.concurrent.*;

/**
 * Created by hr on 2017/08/21.
 */
public class ExecutorsTest {

    public static void main(String[] args) {

        //内部使用 LinkedBlockingDeque<Runnable>() , 任务队列长度 Integer.max ，线程池线程数量最多为10个（初始化）
        ExecutorService executorService1 = Executors.newFixedThreadPool(10);

        //内部使用 SynchronousQueue<Runnable>() , 任务队列长度最大为 1，线程池线程数量最多为 Integer.max
        ExecutorService executorService2 = Executors.newCachedThreadPool();

        //内部使用 DelayedWorkQueue() 延迟队列
        Executors.newScheduledThreadPool(10);
    }
}
