package com.sc.ms.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyResource {
    private volatile boolean FLAG = true;
    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProd() throws InterruptedException {
        String data;
        while (FLAG) {
            data = String.valueOf(atomicInteger.incrementAndGet());
            if (blockingQueue.offer(data, 2L, TimeUnit.SECONDS)) {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "\t 生产叫停");
    }

    public void myConsumer() throws InterruptedException {
        while (true) {
            String data = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (data == null || data.equalsIgnoreCase("")) {
                System.out.println("超时获取，直接退出");
                System.out.println(Thread.currentThread().getName() + "\t 超时获取，直接退出");
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t 消费队列" + data + "成功");
        }
    }

    public void stop(){
        this.FLAG = false;
    }
}

public class ProdConsumer_BlockQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(3));

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 生产启动");
            try {
                myResource.myProd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AA").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 消费启动");
            try {
                myResource.myConsumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "BB").start();

        TimeUnit.SECONDS.sleep(5);
        myResource.stop();
        System.out.println(Thread.currentThread().getName() + "\t 叫停");
    }
}
