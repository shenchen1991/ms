package com.sc.ms.demo.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * AQS
 *
 * @author 沈陈
 * @date 2021/01/09
 **/
public class AQSDemo {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("A Thead come in");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "A").start();

        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("B Thead come in");
//                TimeUnit.SECONDS.sleep(2);
            } finally {
                lock.unlock();
            }
        }, "B").start();

        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("C Thead come in");
//                TimeUnit.SECONDS.sleep(2);
            } finally {
                lock.unlock();
            }
        }, "C").start();
    }


}
