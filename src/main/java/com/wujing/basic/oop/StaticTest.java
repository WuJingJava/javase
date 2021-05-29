package com.wujing.basic.oop;

/**
 * @ClassName: StaticTest
 * @Description: static关键字
 * @Author liujiexin
 * @Date 2021/5/24 11:37 下午
 */
public class StaticTest {

    public static void main(String[] args) {
        StaticClass staticClass = new StaticClass();

    }

     static  class StaticClass{
         public StaticClass() {
             System.out.println("staticClass");
         }
     }
}
