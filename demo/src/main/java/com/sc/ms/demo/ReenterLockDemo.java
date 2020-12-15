package com.sc.ms.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: ms
 * @description: 锁
 * @author: 沈陈
 * @create: 2020-12-01 15:39
 **/

class Phone {
//    public synchronized void sendSms() {
//        System.out.println(Thread.currentThread().getId() + "\t invoke sendSms");
//        sendEmail();
//    }
//
//    private synchronized void sendEmail() {
//        System.out.println(Thread.currentThread().getId() + "\t invoke sendEmail");
//    }

    Lock lock = new ReentrantLock();

    public void get() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getId() + "\t invoke get");
            set();
        } finally {
            lock.unlock();
        }
    }

    public void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getId() + "\t invoke set");
        } finally {
            lock.unlock();
        }
    }

}

public class ReenterLockDemo {


    public static void main(String[] args) {
        Phone phone = new Phone();
//        new Thread(phone::sendSms).start();
//        new Thread(phone::sendSms).start();

        new Thread(phone::get).start();
        new Thread(phone::get).start();

    }
}
