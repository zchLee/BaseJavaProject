package com.lea.day9;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系
 *
 * @author aCheng
 * @create 2020/09/02 上午 11:25
 */
public class _3_MyGenericMethod {

    @Test
    public void test() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> copy = copy(integers);
        System.out.println(copy);
    }

    // 泛型方法需要在 权限修饰符后 写<E> 类似类泛型的标识，此方法才是泛型方法
    // 参数类型和返回值类型要一致？
    // 泛型方法可以是静态的. 泛型方法参数是在调用方法时确定的，而不是实例化类时确定
    public static <E> List<E> copy(List<E> array) {
        List<E> arr = new ArrayList<>();
        for (E e : array) {
            arr.add(e);
        }
        return arr;
    }
}
