package com.hr.juc.forkjoin;

import java.util.concurrent.*;

/**
 * fork/join 框架，是一个并行处理框架，在juc包中
 *
 * fork：
 *  将一个大任务细分化，细分到一定程度之后（用户自己设置），加入到若干个任务队列（双向队列）
 *  每个队列分配一个线程去处理（从队列头开始取）
 *  假如某一个队列的任务已经被处理完了，但是还有其它队列中还有任务，那么使用工作窃取算法
 *  工作窃取：该线程去处理其他队列的任务（从队列尾开始取）
 *
 * join:
 *  把fork之后的结果给合并起来
 *
 * fork/join 有两个实现类：
 *  RecursiveTask<E> 对应有返回结果的任务
 *  RecursiveAction 对应无返回结果的任务
 */
public class ForkJoinTest {

    public static void main(String[] args) {

        CountTask task = new CountTask(1, 10);
        Future<Integer> result = new ForkJoinPool().submit(task);

        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class CountTask extends RecursiveTask<Integer>{

    private static final int THRESHOLD = 2;

    private int begin;
    private int end;

    public CountTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (end - begin) <= THRESHOLD;
        if(canCompute){
            for (int i=begin; i<=end; i++){
                sum += i;
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            int middle = (begin + end)/2;
            CountTask left = new CountTask(begin, middle);
            CountTask right = new CountTask(middle+1, end);

            left.fork();
            right.fork();

            int leftResult = left.join();
            int rightResult = right.join();

            sum = leftResult + rightResult;
        }

        return sum;
    }
}
