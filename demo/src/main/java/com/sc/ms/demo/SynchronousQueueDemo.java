package com.sc.ms.demo;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();
        new Thread(() -> {
            try {

                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName() + "\t put 1");

                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName() + "\t put 2");

                blockingQueue.put("3");
                System.out.println(Thread.currentThread().getName() + "\t put 3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AAA").start();


        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "\t" + blockingQueue.take());

                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "\t" + blockingQueue.take());

                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "\t" + blockingQueue.take());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "BBB").start();

    }
}
