package com.hr.juc.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by hr on 2017/08/10.
 */
public class ForkJoinTest {

    public static void main(String[] args) {
        CountTask task = new CountTask(1, 100);
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
