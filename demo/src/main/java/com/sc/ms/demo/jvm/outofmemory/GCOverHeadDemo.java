package com.sc.ms.demo.jvm.outofmemory;

import java.util.ArrayList;
import java.util.List;


/**
 * GC过长
 *
 * @author 沈陈
 * @date 2020/12/25
 */
public class GCOverHeadDemo {

    public static void main(String[] args) {

        int i = 0;
        List<String> list = new ArrayList<>();

        try {
            while (true) {
                list.add(String.valueOf(++i).intern());
            }
        } catch (Throwable e) {
            System.out.println("********************i：" + i);
            e.printStackTrace();
        }

    }
}
