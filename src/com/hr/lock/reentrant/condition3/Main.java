package com.hr.lock.reentrant.condition3;

/**
 * Created by Administrator on 2017/6/7 0007.
 */
public class Main {

    public static void main(String[] args) {
        Task task = new Task();
        Thread producer = new Thread(new Producer(task));
        Thread consumer = new Thread(new Consumer(task));

        producer.start();
        consumer.start();

        /*

        多生产者对多消费者，需要把 signal 改成 signalAll

        Thread[] producers = new Thread[10];
        Thread[] consumers = new Thread[10];

        for (int i = 0; i < producers.length; i++) {
            producers[i] = new Thread(new Producer(task));
            consumers[i] = new Thread(new Consumer(task));
            producers[i].start();
            consumers[i].start();
        }

        */
    }
}
