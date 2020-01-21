package com.jerry.concurrency.synchronize;

import com.jerry.concurrency.annoations.ThreadSafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@ThreadSafe
public class ClassExample {

    // 修饰一个类
    public static void classTest(int j) {
        synchronized (ClassExample.class) {
            for (int i = 0; i < 10; i++) {
                System.out.println("classTest === "+ j +" - " + i);
            }
        }
    }

    public static void main(String[] args) {
        ClassExample example1 = new ClassExample();
        ClassExample example2 = new ClassExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            example1.classTest(1);
        });
        executorService.execute(() -> {
            example2.classTest(2);
        });
    }
}

