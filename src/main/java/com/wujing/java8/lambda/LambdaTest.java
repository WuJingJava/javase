package com.wujing.java8.lambda;

import org.junit.Test;

/**
 * @ClassName: LambdaTest
 * @Description: lambda测试
 * @Author liujiexin
 * @Date 2021/5/30 5:22 下午
 */
public class LambdaTest {


    @Test
    public void test1(){

        Runnable a = new Runnable(){

            @Override
            public void run() {
                System.out.println("哈哈哈哈哈哈哈");
            }
        };
        a.run();


        System.out.println("分割线");

        Runnable a2 = () -> System.out.println("你好");
        a2.run();

    }
}
