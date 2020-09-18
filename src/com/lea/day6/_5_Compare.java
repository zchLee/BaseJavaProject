package com.lea.day6;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一、实现Compare接口或Comparable接口 进行两个对象之间的比较
 * 区别：Comparable接口与Comparator的区别
 *   实现Comparable接口方式一旦确定，保证Comparable接口在任何位置都可以比较大小
 *   comparator接口临时性的比较.
 *
 * @author aCheng
 * @create 2020/08/21 下午 1:37
 */
public class _5_Compare {

    /*
        Comparable接口使用举例：  自然排序
            1.像String、包装类实现了Comparable接口，重写comparableTo(obj)方法，给出了两个比较对象
            2.像String、包装类重写comparableTo(obj)方法以后，进行从小到大的排序
            3. 重写comparableTo(obj)规则：
                 如果当前对象this大于形参obj，则返回正整数；
                 如果当前对象this小于形参obj，则返回负整数；
                 如果当前对象this等于形参obj，则返回0；
            4. 对于自定义类，如果需要排序，我们就可以让自定义类实现Comparable接口，重写comparableTo(obj) 指明如何排序
     */
    @Test
    public void test() {
//        System.out.println((int) Math.ceil(0.2));
        Good[] goods = new Good[4];
        goods[0] = new Good("神舟", 1.8);
        goods[1] = new Good("戴尔", 1.1);
        goods[2] = new Good("联想", 1.6);
        goods[3] = new Good("华硕", 1.3);
        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));
    }

    /*
        定制排序： Comparator接口的使用
        1. 背景
        当元素的类型没有实现java.lang.Comparator接口而又不方便修改源码
        或者实现了java.lamg.Comparator接口的排序规则又不适合当前操作
        那么可以考虑使用Comparator的对象排序
     */
    @Test
    public void comparetorTest() {
        String[] arr = new String[]{"AA","FF","CC", "RR","WW","EE"};
        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof  String) {
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }
                return 0;
            }
        });
//        Arrays.sort(arr, (Object o1, Object o2) -> {
//                if (o1 instanceof String && o2 instanceof  String) {
//                    String s1 = (String) o1;
//                    String s2 = (String) o2;
//                    return -s1.compareTo(s2);
//                }
//                return 0;
//        });
        System.out.println(Arrays.toString(arr));
    }

}


class Good implements Comparable {

    private String name;
    private double price;

    public Good() {
    }

    public Good(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Good{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Good) {
            Good s = (Good) o;
//            if (this.getPrice() > s.price) {
//                return 1;
//            }else if (this.getPrice() < s.getPrice()) {
//                return -1;
//            }else{
//                return 0;
//            }
            return Double.compare(this.getPrice(), s.getPrice());
        }
        throw new RuntimeException("运行时异常");
    }
}




