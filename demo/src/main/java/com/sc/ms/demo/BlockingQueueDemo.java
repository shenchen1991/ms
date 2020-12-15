package com.sc.ms.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        // 抛出异常
//        System.out.println(blockingQueue.add("3"));
//        System.out.println(blockingQueue.add("3"));
//        System.out.println(blockingQueue.add("3"));
//
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.element());

        // 布尔型
//        System.out.println(blockingQueue.offer("3"));
//        System.out.println(blockingQueue.offer("3"));
//        System.out.println(blockingQueue.offer("3"));
//        System.out.println(blockingQueue.offer("3"));
//
//        System.out.println(blockingQueue.peek());
//
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());


        // 阻塞
//        blockingQueue.put("3");
//        blockingQueue.put("3");
//        blockingQueue.put("3");
//        System.out.println("======================================");
//
//        blockingQueue.take();
//        blockingQueue.take();
//        blockingQueue.take();
//        blockingQueue.take();

        // 超时

        System.out.println(blockingQueue.offer("a",2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a",2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a",2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a",2L, TimeUnit.SECONDS));


    }
}
