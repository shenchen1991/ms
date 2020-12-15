package com.sc.ms.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @program: ms
 * @description: 对象应用
 * @author: 沈陈
 * @create: 2020-11-30 16:56
 **/
@Getter
@ToString
@AllArgsConstructor
class User{
    String userName;
    int age;
}

public class AtomicReferenceDemo {
    public static void main(String[] args) {

        User zhangSan = new User("张三",19);
        User liSi = new User("李四",29);

        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(zhangSan);

        System.out.println(atomicReference.compareAndSet(zhangSan,liSi) + "\t "+ atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(zhangSan,liSi) + "\t "+ atomicReference.get().toString());
    }
}
