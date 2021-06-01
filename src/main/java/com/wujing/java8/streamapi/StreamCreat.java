package com.wujing.java8.streamapi;

import org.junit.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ClassName: StreamAPI
 * @Description: StreamAPI 测试
 * @Author liujiexin
 * @Date 2021/6/1 9:18 下午
 */
public class StreamCreat {

    /**
     * @Description:  创建Stream 对象 方式一：通过集合
     * @Param:
     * @return: void
     * @Author: liujiexin
     * @Date: 2021/6/1 9:46 下午
     */
    @Test
    public void test1(){
        /**
         * 区别 顺序流，顺序读取数据，并行流，并行读取数据
        */

        List<String> list = new ArrayList<>();

        //  default Stream<E> stream() 顺序流
        Stream<String> stream = list.stream();

        //  default Stream<E> stream() 并行流
        Stream<String> parallelStream = list.parallelStream();

    }

    /**
     * @Description:  创建Stream 对象 方式二：通过数组
     * @Param:
     * @return: void
     * @Author: liujiexin
     * @Date: 2021/6/1 9:46 下午
     */
    @Test
    public void test2(){

       int[] arr = new int[]{1,2,3,4};
       // public static IntStream stream(int[] array)
       IntStream stream = Arrays.stream(arr);
    }


    /**
     * @Description:  创建Stream 对象 方式三：Stream 的 of
     * @Param:
     * @return: void
     * @Author: liujiexin
     * @Date: 2021/6/1 9:46 下午
     */
    @Test
    public void test3(){

        // public static<T> Stream<T> of(T... values)
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);

    }


    /**
     * @Description:  创建Stream 对象 方式四：创建无限流
     * @Param:
     * @return: void
     * @Author: liujiexin
     * @Date: 2021/6/1 9:46 下午
     */
    @Test
    public void test4(){

        Stream.iterate(0, t->t+2).limit(10).forEach(System.out :: println);

    }

}
