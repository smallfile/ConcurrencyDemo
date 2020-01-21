package com.jerry.concurrency.synchronize;

import com.jerry.concurrency.annoations.ThreadSafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@ThreadSafe
public class CodeBlockExample1 {

    // 修饰一个代码块
    public void codeBlockTest(int j) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println("codeBlockTest === "+ j +" - " + i);
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CodeBlockExample1 example1 = new CodeBlockExample1();
        executorService.execute(() -> {
            example1.codeBlockTest(1);
        });
        executorService.execute(() -> {
            example1.codeBlockTest(2);
        });
    }
}
