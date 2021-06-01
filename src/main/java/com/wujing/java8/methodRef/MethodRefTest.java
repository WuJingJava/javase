package com.wujing.java8.methodRef;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @ClassName: MethodRefTest
 * @Description: 方法引用
 * 1、使用情景：当要传递给Lambda 体的操作，已经有实现的方法了，可以使用方法引用。
 * 2、方法引用的本质上就是Lambda的表达式，而Lambda表达式作为函数式接口的实例，所以方法引用，
 * 也就是函数式接口的实例
 * 3、使用格式：类（或对象）:: 方法名
 * <p>
 * 4、具体分为如下三种情况
 *  对象 :: 非静态方法
 *  类 :: 静态方法
 *  类 ::  非静态方法（此时方法参数不一致时，第一个参数看参数是否是方法的调用者）
 *
 * 5、方法引用使用的要求：
 *      要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的形参列表和返回值类型相同！
 *          仅适用于： 对象 :: 非静态方法、类 :: 静态方法
 * @Author liujiexin
 * @Date 2021/5/31 11:19 下午
 */
public class MethodRefTest {

    /**
     * @Description: 对象 :: 实例方法
     * @Param:
     * @return: void
     * @Author: liujiexin
     * @Date: 2021/5/31 11:28 下午
     */
    @Test
    public void test1() {

        Consumer<String> consumer = str -> System.out.println(str);
        consumer.accept("Lambda 表达式写法");

        Consumer<String> consumer1 = System.out::println;
        consumer1.accept("引用对象写法");

    }


    /**
     * @Description: 对象 :: 实例方法
     * @Param:
     * @return: void
     * @Author: liujiexin
     * @Date: 2021/5/31 11:28 下午
     */
    @Test
    public void test2() {

        Person person = new Person(1, "张三", 20);


        Supplier<String> supplier = () -> person.getName();
        System.out.println(supplier.get());



        Person person2 = new Person(1, "李四", 20);

        Supplier<String> supplier1 = person2 :: getName;
        System.out.println(supplier1.get());

    }

    /**
     * @Description: 类 :: 静态方法
     * @Param:
     * @return: void
     * @Author: liujiexin
     * @Date: 2021/5/31 11:28 下午
     */
    @Test
    public void test3() {

        Comparator<Integer> comparator = (i1,i2) -> Integer.compare(i1,i2);
        System.out.println( comparator.compare(10, 20));


        Comparator<Integer> comparator2 = Integer :: compare;
        System.out.println( comparator2.compare(10, 20));
    }

    /**
     * @Description: 类 :: 静态方法
     * @Param:
     * @return: void
     * @Author: liujiexin
     * @Date: 2021/5/31 11:28 下午
     */
    @Test
    public void test4() {

        Function<Double, Long> function = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };
        System.out.println(function.apply(10.9));

        Function<Double, Long> function1 = Math :: round;
        System.out.println(function1.apply(10.5));

    }



    /**
     * @Description: 类 :: 实例方法
     * @Param:
     * @return: void
     * @Author: liujiexin
     * @Date: 2021/5/31 11:28 下午
     */
    @Test
    public void test5() {

        Comparator<String> comparator = (s1,s2) -> s1.compareTo(s2);
        System.out.println( comparator.compare("a", "an"));


        Comparator<String> comparator2 = String :: compareTo;
        System.out.println( comparator.compare("a", "an"));

    }
}

