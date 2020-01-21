package com.jerry.concurrency.publish;

import com.jerry.concurrency.annoations.UnThreadSafe;

import java.util.Arrays;

@UnThreadSafe
public class PublishExample {

    private String[] states = {"a", "b", "c"};
    public String[] getStates() {
        return states;
    }

    public static void main(String[] args) {
        //发布对象
        PublishExample unsafePublish = new PublishExample();
        System.out.println("数组值 == " + Arrays.toString(unsafePublish.getStates()));
        //修改对象的值
        unsafePublish.getStates()[0] = "d";
        System.out.println("数组值 == " + Arrays.toString(unsafePublish.getStates()));
        //若多个对象同时修改states的值，则无法保证值的最终结果
    }
}