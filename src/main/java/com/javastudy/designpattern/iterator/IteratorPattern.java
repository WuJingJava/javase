package com.javastudy.designpattern.iterator;

import java.util.*;

/**
 * @ClassName: IteratorPattern
 * @Description: 迭代器模式
 *
 * 提供一种方法顺序访问一个聚合对象中各个元素, 而又无须暴露该对象的内部表示。
 * 主要用于 遍历元素
 * @Author liujiexin
 * @Date 2021/5/15 下午6:49
 */
public class IteratorPattern {

    public static void main(String[] args) {

        List<String> arrayList = new ArrayList<String>();
        arrayList.add("张三");
        arrayList.add("李四");

        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
//            System.out.println(iterator.toString());
        }


        Set<String> set = new HashSet<String>();
        set.add("王五");
        set.add("赵六");

        Iterator<String> setIterator = set.iterator();
        while (setIterator.hasNext()){
            String next = setIterator.next();
            System.out.println(next);
//            System.out.println(iterator.toString());
        }

    }
}
