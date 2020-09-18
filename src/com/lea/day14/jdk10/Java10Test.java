package com.lea.day14.jdk10;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author lzc
 * @create 2020/09/17 下午 4:58
 */
public class Java10Test {

    /*
        局部变量的类型推断  var：非关键字，是一个类型名
         注意:
            右边要写明类型，或者能直接推断出来的类型。

        var 不能是方法返回类型，方法参数类型，构造器参数类型，成员属性，catch(异常)
     */
    @Test
    public void test() {
        int num = 10;
        // 局部变量的类型推断  var：关键字
        var nu1 = 10;

        var list = new ArrayList<String>();
        list.add("fdsasf");
//      lambda表达式左边不能声明为var, 方法引用也不适用
//        var lambda = () -> Math.random();
    }
}
