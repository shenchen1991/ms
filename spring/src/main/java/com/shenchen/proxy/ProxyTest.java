package com.shenchen.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 沈陈
 * @date 2021/04/13
 **/
public class ProxyTest {

    public static void main(String[] args) {
//        SubObject subObject = (SubObject) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), new Class<?>[]{SubObject.class}, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println(method.getName());
//                return null;
//            }
//        });
//
//        subObject.sayHello("test");
        double x = 1.85;
        double y = 4.30;
        double z = 5.21;
        double total = 100;
        double payX = 100 / x;
        double payY = 100 / y;
        double payZ = 100 / z;

        double totalPay = payX + payY + payZ;

        System.out.println("x = " + payX);
        System.out.println("y = " + payY);
        System.out.println("z = " + payZ);
        System.out.println(totalPay);

    }
}
