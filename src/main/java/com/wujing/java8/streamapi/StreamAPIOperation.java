package com.wujing.java8.streamapi;

import com.wujing.java8.methodRef.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @ClassName: StreamAPIOperation
 * @Description: Steam的操作
 * @Author liujiexin
 * @Date 2021/6/1 10:02 下午
 */
public class StreamAPIOperation {

    /**
     * @Description: filter limit
     * @Param:
     * @return: void
     * @Author: liujiexin
     * @Date: 2021/6/1 11:28 下午
     */
    @Test
    public void test1(){

        List<Person> list = Person.getPersons();
        Stream<Person> stream = list.stream();

        // filter(Predicate<? super T> predicate); 此处接收一个 predicate 的实现类
        stream.filter(new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return person.getAge() > 39;
            }
        }).forEach(System.out :: println);
        // 使用lambda 表达式写法
        Stream<Person> stream2 = list.stream();
        stream2.filter(e -> e.getAge() > 39).forEach(System.out :: println);

        System.out.println("------------------limit---------------------");

        // limit()
        Stream<Person> streamLimit = list.stream();
        streamLimit.limit(3).forEach(System.out :: println);
    }


    /**
     * @Description: filter limit
     * @Param:
     * @return: void
     * @Author: liujiexin
     * @Date: 2021/6/1 11:28 下午
     */
    @Test
    public void test2(){

        List<Person> list = Person.getPersons();
        Stream<Person> stream = list.stream();

        // skip 在丢弃流的前n元素后，返回由该流的其余元素组成的流。 如果此流包含少于n元素，则将返回一个空流。
        stream.skip(9).forEach(System.out :: println);

        // distinct()
        Stream<Person> stream2 = list.stream();
        stream2.distinct().forEach(System.out :: println);
    }


    /**
     * @Description: 映射 map
     * @Param:
     * @return: void
     * @Author: liujiexin
     * @Date: 2021/6/1 11:28 下午
     */
    @Test
    public void test3(){

        List<String> list = Arrays.asList("aa","bb","cc","dd","ee","ff");
        Stream<String> stream = list.stream();

        //
        stream.map(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        }).forEach(System.out :: println);

        System.out.println("------------------map---------------------");

        Stream<String> stream2 = list.stream();

        // <R> Stream<R> map(Function<? super T, ? extends R> mapper);
        stream2.map(s -> s.toUpperCase()).forEach(System.out :: println);

        System.out.println("------------------map---------------------");

        // 获取名字长度 大于3的 所有的名称
        List<Person> personsList = Person.getPersons();
        Stream<Person> streamPerson = personsList.stream();

        Stream<String> stringStream = streamPerson.map(Person::getName);
        stringStream.filter(s -> s.length() >= 3).forEach(System.out :: println);


    }

    /**
     * @Description: 映射 map
     * @Param:
     * @return: void
     * @Author: liujiexin
     * @Date: 2021/6/1 11:28 下午
     */
    @Test
    public void test4(){

        List<String> list = Arrays.asList("aa","bb","cc","dd","ee","ff");
        Stream<String> stream = list.stream();

        //
        stream.map(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        }).forEach(System.out :: println);

        System.out.println("------------------map---------------------");

        Stream<String> stream2 = list.stream();

        // <R> Stream<R> map(Function<? super T, ? extends R> mapper);
        stream2.map(s -> s.toUpperCase()).forEach(System.out :: println);

        System.out.println("------------------map---------------------");

        // 获取名字长度 大于3的 所有的名称
        List<Person> personsList = Person.getPersons();
        Stream<Person> streamPerson = personsList.stream();

        Stream<String> stringStream = streamPerson.map(Person::getName);
        stringStream.filter(s -> s.length() >= 3).forEach(System.out :: println);


    }
}
