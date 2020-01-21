package com.jerry.concurrency.synchronize;

import com.jerry.concurrency.annoations.UnThreadSafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@UnThreadSafe
public class CodeBlockExample2 {

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
        CodeBlockExample2 example1 = new CodeBlockExample2();
        CodeBlockExample2 example2 = new CodeBlockExample2();
        executorService.execute(() -> {
            example1.codeBlockTest(1);
        });
        executorService.execute(() -> {
            example2.codeBlockTest(2);
        });
    }
}
