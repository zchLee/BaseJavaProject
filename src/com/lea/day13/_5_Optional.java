package com.lea.day13;

import org.junit.Test;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Optional;

/**
 * Optional类：为了程序中避免出现空指针异常而创建的。
 *
 * 常用方法：
 *  ofNullable(T t)
 *
 *  get(): 获取当前值，如果值为空，抛出异常
 *
 *  orElse(T t) :  包装类型不为空，则返回，如果为空就返回方法中的t
 *
 *  orElseThrow(Supplier<? extends X> exceptionSupplier): 包装类型不为空，则返回，如果为空就抛出异常
 *
 * @author lzc
 * @create 2020/09/16 下午 3:08
 */
public class _5_Optional {

    /*
    Optional.of(T t):创建一个Optional实例，t必须非空
    Optional.empty(); 创建一个空的Optional实例
    Optional.ofNullable(T t); t可以为null
     */
    @Test
    public void test1() {
        Boy boy = new Boy();
        // t必须非空
        Optional<Boy> optionalBoy = Optional.of(new Boy());

        Girl girl = null;
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        System.out.println(optionalBoy);
        System.out.println(optionalGirl);
    }

    @Test
    public void test2() {
        Boy boy = new Boy(new Girl("苍老师"));
        boy = null;
        System.out.println(getGirlName(boy));
    }
    // 使用Optional类防止空指针异常
    public String getGirlName(Boy boy) {
        Optional<Boy> optionalBoy = Optional.ofNullable(boy);
        // 如果当前的optional内部t非空，则返回内部的t。如果为空，就返回方法中的形参T
        Boy b = optionalBoy.orElse(new Boy(new Girl("玛丽莲.梦露")));

        Optional<Girl> optionalGirl = Optional.ofNullable(b.getGirl());
        Girl girl = optionalGirl.orElse(new Girl("所谓伊人，在哪呢"));
        return girl.getName();
    }
}
