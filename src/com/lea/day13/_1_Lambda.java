package com.lea.day13;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 * lambda表达式的使用
 *  1. 举例：(o1,o2) -> Integer.compare(o1, o2);
 *  2. 格式：
 *      ->: lambda操作符 或 箭头操作符
 *      ->左边：lambda的形参列表（接口中的抽象方法的形参列表）
 *      ->右边: lambda体 （重写的抽象方法的方法体）
 *  3. Lambda表达式的使用：（6种情况）
 *
 *      总结:
 *       ->左边：lambda形参列表的参数类型可以省略（类型推断）；如果lambda形参列表只有一个参数，参数小括号也能省略
 *       ->右边：lambda体应该使用一对{}包裹，如果lambda体只有一条执行语句（可能是return语句），也可以省略这一对{}和return关键字
 *
 *  4. Lambda表达式的本质：作为接口的实例
 *
 * @author aCheng
 * @create 2020/09/11 下午 5:27
 */
public class _1_Lambda {

    /*
    语法方式一：无参，无返回值
     */
    @Test
    public void test1() {
        Runnable r = () -> System.out.println("谎言和誓言的区别是什么？");
        r.run();
    }

    /*
    语法方式二：需要一个参数，但是没有返回值
     */
    @Test
    public void test2() {
        Consumer<String> con = (String s) -> {System.out.println(s);};
        con.accept("一个是听的人当了真，一个是说的人当了真");
    }

    /*
    语法方式三：参数类型可以省略 需要一个参数，但是没有返回值
    编译器可推断得出，称为“类型推断”
     */
    @Test
    public void test3() {
        Consumer con = (s) -> {System.out.println(s);};
        con.accept("还有一个人省略了参数类型");
    }

    /*
    类型推断
     */
    @Test
    public void test4() {
        List<Integer> list = new ArrayList<>();
        int[] arr = {1,2,3};
    }

    /*
    语法格式四：lambda 若只需要一个参数时，参数的小括号可以省略
     */
    @Test
    public void test5() {
        Consumer con = s -> {System.out.println(s);};
        con.accept("还有一个人省略了参数类型");
    }

    /*
    语法格式五：lambda 若只需要两个或两个以上的参数，多条执行语句，并且可以有放回值
     */
    @Test
    public void test6() {
        Comparator<Integer> com = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return Integer.compare(o1,o2);
        };
        System.out.println(com.compare(0, 21));
    }


    /*
   语法格式六：lambda 方法体只有一条语句时，return 与大括号都可以省略
    */
    @Test
    public void test7() {
        Comparator<Integer> com = (o1, o2) -> Integer.compare(o1,o2);
        System.out.println(com.compare(0, 21));
    }
}
