package com.lea.day8;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Collection 接口
 *  |---Set接口： 无序、不可重复的数据                       ---》集合
 *     |--- HashSet：            Set接口主要实现类，线程不安全。可以存储null值
 *          |--- LinkedHashSet： HashSet子类，遍历内部数据时，可以按照添加的顺序遍历
 *                      linkedHashSet作为HashSet子类，在添加数据时，每个数据还维护了两个引用，
 *                                          记录此数据的前一个数据和后一个数据。
 *
 *         优点：对于比频繁的遍历操作，LinkedHashSet效率高于HashSet
 *     |--- TreeSet：可以按照添加对象的指定属性，进行排序
 *
 * @author aCheng
 * @create 2020/08/30 下午 8:06
 */
public class _3_Set {

    /*
    Set: 存储无序、不可重复的数据：
       以HashSet为例说明：
        1.无序： 不等于随机性。存储的数据在底层数组中，并非按照数组索引的先后顺序添加，而是根据数据的哈希值决定。

        2. 不可重复：保证添加的元素按照equals()方法判断时，不能放回true。即相同的元素只能添加一个。

     添加元素的过程： 以HashSet为例
        我们向HashSet中添加元素a，首先调用元素a所在类的hashCode()方法，计算元素a的hash值，
        接着通过算法计算出HashSet底层数组的存放位置（索引位置），判断数组此位置上是否有元素，
        如果此位置没有其他元素，那么元素a直接添加成功。                --->情况1
        如果此位置上有其他元素（或链表形式存在的多个元素），比较元素a与其他元素的hash值：
            如果hash值不同，元素a在原有的数据以链表形式添加进来        --->情况2
            如果hash值相同，调用元素a的所在类的equals()方法：
                如果equals()方法返回true：元素a添加失败
                如果equals() 方法返回false，则元素a在该数组的位置，以链表形式添加到原有数据链表中 --->情况3


         对于添加成功的2,3情况而言，元素a与已经存在的指定索引位置上数据以链表方式存储。
         在jdk7中：元素a放在数组中，指向原来数组中的元素
         在jdk8中：原来的元素在数组中，链表末尾指向元素a

    1. HashSet底层是数组加链表结构, 实际上是HashMap
    2. 要求：向Set中添加的数据，其所在类一定要重写hashCode() and equals()方法
       要求: 重写hashCode()和equals()尽可能一致性（相等的对象必须有相等的散列码）
     */


    // hashSet演示
    @Test
    public void hashSet() {
        HashSet<Object> objects = new HashSet<>();
        objects.add("CC");
        objects.add(456);
        objects.add("HH");
        objects.add("AA");
        objects.add(123);
        objects.add("BB");
        for (Object o : objects) {
            System.out.println(o);
        }
    }

    // linkedHashSet演示
    /*
        linkedHashSet作为HashSet子类，在添加数据时，每个数据还维护了两个引用，
        记录此数据的前一个数据和后一个数据。

        优点：对于比频繁的遍历操作，LinkedHashSet效率高于HashSet
     */
    @Test
    public void linkedHashSet() {
        HashSet<Object> objs = new LinkedHashSet<>();
        objs.add(456);
        objs.add("CC");
        objs.add("AA");
        objs.add("HH");
        objs.add("BB");
        objs.add(123);
        for (Object o : objs) {
            System.out.println(o);
        }
    }

    // TreeSet演示
    /*
        1.TreeSet中添加的数据，要求是相同类型的对象
        2.输出数据会按照类对象规定的排序输出
            自然排序 (Comparatorable)
                比较两个对象是否相同的标准，compareTo() 返回0，不再是equals()
            定制排序（Comparator）
                比较两个对象是否相同的标准，compare(Object o1， Object o2) 返回0，不再是equals()
        注意：TreeSet是按照重写的排序方法来判断是否相同的，排序方法返回0就是相同，添加失败

        底层是树形结构（小的在左边，大的在右边），准确讲是红黑树结构
     */
    @Test
    public void treeSet() {
        Set<Object> objs = new TreeSet<>();
        objs.add(456);
        objs.add(123);
//        objs.add("CC");
//        objs.add("HH");
//        objs.add("BB");
        for (Object o : objs) {
            System.out.println(o);
        }
    }
    // treeSet定制排序演示
    @Test
    public void treeSet2() {
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof  Integer && o2 instanceof  Integer) {
                    return (Integer) o2-(Integer) o1;
                }
                throw new ClassCastException("类型错误");
            }
        };
        Set<Object> objs = new TreeSet<>(comparator);
        objs.add(456);
        objs.add(123);
        objs.add(7843);
        objs.add(31);
        objs.add(43);
//        objs.add("CC");
//        objs.add("HH");
//        objs.add("BB");
        for (Object o : objs) {
            System.out.println(o);
        }
    }
}
