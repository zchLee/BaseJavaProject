package com.lea.day9;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型在继承方面的体现
 *
 * @author aCheng
 * @create 2020/09/02 下午 1:45
 */
public class _4_GenericExtends {
    /*
      1、 泛型在继承方面的体现
        类A是类B的父类，那么G<A>和G<B>二者不具备父子类关系， 二者是并列关系

        补充：类A是类B的父类，A<G>是B<G>的父类
     */
    @Test
    public void test() {
        List<Object> o1 = null;
        List<String> o2 = null;
        // 编译不通过
//        o1 = o2;

        /*
        反证法：
        假设o1 = o2
        o1.add(132); 导致非String的数据出错
         */
    }

    /*
    2. 通配符：?
    类A是类B的父类，G<A>和G<B>没有关系，二者共同父类是: G<?>
     */
    @Test
    public void test2() {
        List<Object> o1 = null;
        List<String> o2 = null;

        List<?> list = new ArrayList<>();
        list = o1;
        list = o2;

        ArrayList<String> l3 = new ArrayList<>();
        l3.add("123");
        l3.add("DD");
        list = l3;
        // 添加： List<?>修饰的泛型，不能向其内部添加数据，除了添加null
//        list.add(null);  // null--->所有对象默认值都是null

        // 读取： 可，读取数据类型是Object
        Object o = list.get(0);
        System.out.println(o);
    }

    /*
    3.有限制条件的通配符
    ? extends A:
        G<? extends A> 可以作为G<A>和G<B>的父类的，其中B是A的子类

    ? super A:
        G<? super A> 可以作为G<A>和G<B>的父类的，其中B是A的父类
     */
    @Test
    public void test3() {
//        Class<Object> objectClass = Object.class;
        List<? extends Order> list1 = null;
        List<? super Order> list2 = null;
        // SubOrder 继承 Order
        List<Order> list3 = new ArrayList<>();
        List<SubOrder> list4 = new ArrayList<>();
        List<Object> list5 = new ArrayList<>();
//      ? extends XXXX 表示此泛型是XXX的子类或XXXX本身
        list1 = list3;
        Order order = list1.get(0);
        list1 = list4;
        Order order1 = list1.get(0);
//        list1.add(new Order()); 通配符还是不能复制 编译不通过
//        list1 = list5;  // 编译不通过

        //      ? super XXXX 表示此泛型是XXX的父类或XXXX本身
        list2 = list3;
        Object object = list2.get(0);
//        list2 = list4;  // 编译不通过
        list2 = list5;
        list2.add(new Order());
        list2.add(new SubOrder());
        // super 通配符可以添加数据


    }
}
