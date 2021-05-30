package com.wujing.java8.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @ClassName: LambdaLean
 * @Description: 学习Lambda
 *
 * <code>
 *     举例： (o1,o2) -> Integer.compare(o1,o2)
 *     格式：
 *          -> : lambda 操作符，或者 箭头操作符
 *          ->左边： lambda形参列表（其实就是接口中的抽象方法的形参列表）
 *          ->右边： lambda体（其实就是重写的抽象方法的方法体）
 *
 *     lambda 表达式的使用：（6中情况）
 *          总结：
 *              ->左边： 形参列表的参数类型可以省略，参数只有一个，()也可以省略
 *              ->右边：使用一对{}包裹，若只有一条执行语句，存在return 语句，可以省略{}
 *
 *      lambda表达式的本质：作为接口的实例，接口实现类的实例
 * </code>
 *
 * @Author liujiexin
 * @Date 2021/5/30 10:41 下午
 */
public class LambdaLean {

    /**
     * @Description:  语法一： 无参，无返回值
     * @Param:
     * @return: void
     * @Author: liujiexin
     * @Date: 2021/5/30 10:49 下午
     */
    @Test
    public  void test1(){

        Runnable a = new Runnable(){

            @Override
            public void run() {
                System.out.println("哈哈哈哈哈哈哈");
            }
        };
        a.run();

        //  () -> System.out.println("你好"); 这个整体是一个对象
        Runnable a2 = () -> System.out.println("你好");
        a2.run();

    }

    /**
     * @Description: 语法二： 需要一个参数，无返回值
     * @Param:
     * @return: void
     * @Author: liujiexin
     * @Date: 2021/5/30 10:58 下午
     */
    @Test
    public void  test2(){

        // 常规写法
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("常规写法：一个参数，无返回值");

        // lambda 表达式
        Consumer<String> consumer1 = (String s) -> System.out.println(s);
        consumer1.accept("lambda表达式写法： 一个参数，无返回值");

    }

    /**
     * @Description: 语法三：数据类型可以省略，编译器可以推断得出，成为"类型推断"
     * @Param:
     * @return: void
     * @Author: liujiexin
     * @Date: 2021/5/30 10:58 下午
     */
    @Test
    public void  test3(){

        // lambda 表达式，类型推断
        Consumer<String> consumer1 = (s) -> System.out.println(s);
        consumer1.accept("lambda表达式，类型推断写法： 一个参数，无返回值");

    }

    /**
     * @Description: "类型推断"
     * @Param:
     * @return: void
     * @Author: liujiexin
     * @Date: 2021/5/30 10:58 下午
     */
    @Test
    public void  testArray(){
        // "类型推断"
        ArrayList<String> list = new ArrayList<>();
    }

    /**
     * @Description: 语法四：lambda表达式若只有一个小括号也可以省略。
     * @Param:
     * @return: void
     * @Author: liujiexin
     * @Date: 2021/5/30 10:58 下午
     */
    @Test
    public void  test4(){

        // lambda 表达式，省略小括号 (s) == s
        Consumer<String> consumer1 = s -> System.out.println(s);
        consumer1.accept("lambda表达式，类型推断写法： 一个参数，无返回值");

    }



    /**
     * @Description: 语法五：需要两个或两个以上参数，多条执行语句，并且可以有返回值
     * @Param:
     * @return: void
     * @Author: liujiexin
     * @Date: 2021/5/30 10:58 下午
     */
    @Test
    public void  test5(){

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        int compare = comparator.compare(10, 20);
        System.out.println("常规写法："+compare);

        Comparator<Integer> comparator1 = (o1,o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return  o1.compareTo(o2);
        };
        System.out.println(comparator1.compare(4,3));

    }

    /**
     * @Description: 语法六：若lambda体只有个一条语句，return 与大括号，可以省略
     * @Param:
     * @return: void
     * @Author: liujiexin
     * @Date: 2021/5/30 10:58 下午
     */
    @Test
    public void  test6(){

        Comparator<Integer> comparator1 = (o1,o2) -> o1.compareTo(o2);
        System.out.println(comparator1.compare(4,45));



    }
}
