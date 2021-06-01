package com.wujing.java8.methodRef;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Person
 * @Description: Person
 * @Author liujiexin
 * @Date 2021/6/1 10:06 下午
 */
@Data
@AllArgsConstructor
public  class Person{
    int id;
    String name;
    int age;


    public static List<Person> getPersons(){
        List<Person> list = new ArrayList<>();
        list.add(new Person(1,"张三1", 19));
        list.add(new Person(2,"李四", 29));
        list.add(new Person(3,"王五3", 39));
        list.add(new Person(4,"赵六", 49));
        list.add(new Person(5,"刘七4", 59));
        list.add(new Person(6,"潘嘎", 60));
        list.add(new Person(7,"一爽", 3));
        list.add(new Person(7,"一爽", 66));
        return list;
    }
}
