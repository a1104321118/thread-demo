package com.hr.threadpool;

import java.util.concurrent.*;

/**
 * Created by hr on 2017/08/11.
 */
public class ThreadPoolExecutorTest {

    static int corePoolSize = 10;
    static int maximumPoolSize = 15;
    static long keepAliveTime = 10;
    static BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(10);


    static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, queue);

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(111);
            }
        });

        poolExecutor.execute(thread);//适合没有返回的值的任务

        MyCallable<String> callable = new MyCallable<>();
        Future<String> result = poolExecutor.submit(callable);//适用于有返回值的任务
        try {
            String s = result.get();//会阻塞到直到拿到结果
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        poolExecutor.shutdown();
    }
}

class MyCallable<String> implements Callable<String>{

    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        return (String) "aaa";
    }
}