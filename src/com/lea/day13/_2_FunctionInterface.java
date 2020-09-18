package com.lea.day13;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToLongFunction;

/**
 * 函数式接口
 *  有且只有一个抽象方法，但是可以有多个非抽象方法
 *
 * 作用：
 *  可以被隐式转换成lambda表达式
 *
 * 语法；
 * @FunctionInterface
 * 接口类 {
 *    // 有且只有一个抽象方法
 *    void method();
 * }
 *
 * @author aCheng
 * @create 2020/09/11 下午 9:31
 */
public class _2_FunctionInterface {

    /*
    四大内置函数式接口
        消费型接口：对类型为T的对象应用操作
            Consumer<T> void accept(T t);

        供给型接口：返回类型为T的对象
            Supplier<T> T get();

        函数型接口：对类型为T的对象应用操作，并返回结果R类型对象
            Function<T, R> R apply(T t);

        断定型接口：判断类型为T的对象是否满足某约束并返回boolean值
            Predicate<T> boolean test(T t);
     */
    @Test
    public void testConsumer() {
        Consumer<Double> con = o -> {
            System.out.println("价钱加" + (o += 500) + "元");
        };
        Double i = new Double(3);
        con.accept(i);
    }

    @Test
    public void testPredicate() {
        Predicate<String> predicate = o -> o.length() > 3;
        List<String> strings = Arrays.asList("abcd", "a", "ab", "efghijk");
        System.out.println("字符长度大于3的字符串");
        for (String s : strings) {
            if (predicate.test(s)) {
                System.out.println(s);
            }
        }
    }

    @Test
    public void testOther() {
        List<String> strings = Arrays.asList("1", "2", "3", "4", "5");
        ToLongFunction<String> toLong = o -> Long.valueOf(o);
        for (String s : strings) {
            long l = toLong.applyAsLong(s);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        FunctionInterface f = () -> System.out.println("函数式接口");
        f.message();
    }
}

@FunctionalInterface
interface FunctionInterface {
    void message();
}
