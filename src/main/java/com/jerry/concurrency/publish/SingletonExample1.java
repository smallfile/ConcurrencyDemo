package com.jerry.concurrency.publish;

import com.jerry.concurrency.annoations.UnThreadSafe;

/**
 * 懒汉模式
 * 单例实例在第一次使用时进行创建
 */
@UnThreadSafe
public class SingletonExample1 {

    // 私有构造函数
    private SingletonExample1() {

    }

    // 单例对象
    private static SingletonExample1 instance = null;

    // 静态的工厂方法
    public static SingletonExample1 getInstance() {
        // 当有多个线程同时访问时，在此处就有可能出现创建多个对象的情况
        if (instance == null) {
            instance = new SingletonExample1();
        }
        return instance;
    }
}
