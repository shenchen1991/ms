package com.sc.ms.spring;


/**
 * a
 *
 * @author 沈陈
 * @date 2021/03/12
 **/
public class B {

    private A a;

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public B() {
        System.out.println("B created success");
    }
}
