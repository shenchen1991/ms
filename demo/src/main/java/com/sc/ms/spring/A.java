package com.sc.ms.spring;

/**
 * a
 *
 * @author 沈陈
 * @date 2021/03/12
 **/
public class A {

    private B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public A() {
        System.out.println("A created success");
    }
}
