package com.jerry.concurrency.publish;

import com.jerry.concurrency.annoations.UnRecommend;
import com.jerry.concurrency.annoations.UnThreadSafe;

/**
 * 对象溢出案例
 * 对象还未创建完成，就向外发布，会导致发生溢出的错误。
 * 记住对象未创建完成前，不可以向外发布！！！！
 */
@UnThreadSafe
@UnRecommend
public class EscapeExample {

    private int thisCanBeEscape = 0;

    public EscapeExample() {
        //使用内部类
        new InnerClass();
    }

    //声明一个内部类
    private class InnerClass {

        public InnerClass() {
            //内部类中使用了外部类的变量
            System.out.println(EscapeExample.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new EscapeExample();
    }

}
