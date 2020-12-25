package com.sc.ms.demo.jvm;

/**
 * 栈溢出错误演示
 *
 * @author 沈陈
 * @date 2020/12/25
 */
public class StackOverflowErrorDemo {

    public static void main(String[] args) {
        stackOverflowError();
    }

    private static void stackOverflowError() {
        stackOverflowError();
    }
}
