package com.sc.ms.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @program: ms
 * @description:
 * @author: 沈陈
 * @create: 2020-12-10 17:10
 **/
class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 2000;
    }
}

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        FutureTask<Integer> futureTask1= new FutureTask<>(new MyThread());
        new Thread(futureTask, "AA").start();
        new Thread(futureTask1, "bb").start();
        int result001 = 100;
        Integer result = futureTask.get();
        System.out.println(result + result001);

    }

}
