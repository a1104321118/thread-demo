package com.hr.juc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞队列，
 *
 * 阻塞队列有7个实现类，接口为：BlockingQueue
 *
 * 生产者：当不能插入数据的时候，会阻塞等待，
 *      如果在等待时间内，队列又有新的空间，那么操作成功，返回true，
 *      如果超过等待时间后，返回false
 *
 * 消费者：当不能读取数据的时候，会阻塞等待，
 *      如果在等待时间内，队列又有新的元素，那么操作成功，返回该元素，
 *      如果超过等待时间后，返回null
 *
 * LinkedBlockingQueue必须指定容量大小，否则默认容量是Integer.MAX_VALUE，系统内存会被耗尽
 */
public class LinkedBlockingQueueTest {

    public static void main(String[] args) {
        // 声明一个容量为10的缓存队列
        BlockingQueue<String> queue = new LinkedBlockingQueue<String>(10);
        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));
        Thread monitor = new Thread(new Monitor(queue));
        producer.start();
        consumer.start();
        monitor.start();
    }
}

//生产者
class Producer implements Runnable{

    private volatile boolean active = true;
    private BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        //1S插入一条数据
        while (active){
            try {
                //如果队列已经满了，就超时等待1S
                boolean offer = this.queue.offer("1", 1, TimeUnit.SECONDS);
                if (!offer){//等待了之后还没有插入
                    this.stop();
                }
                //TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void stop(){
        active = false;
        System.out.println(this.getClass().getName() + " stop!");
    }
}

//消费者
class Consumer implements Runnable{
    private volatile boolean active = true;
    private BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        //2S取出一条数据
        while (active){
            try {
                String poll = this.queue.poll(2, TimeUnit.SECONDS);//如果没有，超时等待2S
                if(null == poll){
                    this.stop();
                }
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void stop(){
        active = false;
        System.out.println(this.getClass().getName() + " stop!");
    }
}

//监控
class Monitor implements Runnable{

    private volatile boolean active = true;
    private BlockingQueue<String> queue;

    public Monitor(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        //监控，每秒一次
        while (active){
            try {
                System.out.println(this.queue.size());
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void stop(){
        active = false;
    }
}
