package com.wujing.java8.functional;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @ClassName: MyFunctional
 * @Description: 自定义函数式接口
 *
 * <code>
 *     只包含一个抽象方法的接口，称为函数式接口
 *
 *     @FunctionalInterface  校验是否式函数式接口
 * </code>
 * @Author liujiexin
 * @Date 2021/5/30 11:34 下午
 */

@FunctionalInterface
 interface MyFunctional {

    void method1();

    // 定义多个 抽象的方法后，将不是函数式的接口了
    // Multiple non-overriding abstract methods found in interface com.wujing.java8.functional.MyFunctional
//    void method2();
}


public class MyFunctionalTest{

    @Test
    public void test(){
        Runnable runnable = () ->{
            System.out.println(" 多线程");
        };
        runnable.run();
    }

    /**
     * @Description:  java 内置四大核心函数式接口
     *  消费型接口 Consumer<T>  void accept(T t);
     *  供给型接口Supplier<T>    T get();
     *
     * @Param:
     * @return: void
     * @Author: liujiexin
     * @Date: 2021/5/30 11:44 下午
     */
    @Test
    public void test2(){
        // 消费型接口 Consumer<T>  void accept(T t);
        Consumer<String> consumer = (s) -> {
            System.out.println(s);
        };
        consumer.accept("哈哈哈哈哈哈哈");

        // 供给型接口Supplier<T>    T get();
        Supplier<String> supplier = () -> "你好";
        System.out.printf("供给型：%s \n", supplier.get());

        // 函数型接口 Function<T, R>
        Function<String, String> function = (s1) -> {
            return s1+"，哈哈哈哈哈哈";
        };
        System.out.println(function.apply("张三"));

        // 判定型接口 Predicate<T>

        Predicate<Integer> predicate = (a) ->{
          return (a >= 27);
        };
        System.out.println(predicate.test(20));

    }



}