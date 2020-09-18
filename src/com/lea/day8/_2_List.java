package com.lea.day8;

import java.util.Vector;

/**
 * jdk 1.7
 *      new ArrayList(); 底层创建了长度是10的Object[]数组elementData
 *      add(E e); 容器容量不够时，扩容 旧容器>>1 （1.5倍）
 *
 *      故：建议初始化带参构造器 new ArrayList(3);
 *
 * jdk 1.8
 *      new ArrayList(); 底层创建了Object[]初始化为{}，并没有创建长度
 *      第一次add(E e); 操作时，才创建长度为10的数组
 *      后续添加操作与1.7版本一致
 *
 * 小结：
 *  jdk1.7类似于单利的饿汉式，而jdk8中的ArrayList的对象的创建类似于单利的懒汉式。
 *      延迟了数组的创建，节省了内存
 *
 *
 * LinkedList的源码分析：
 *      LinkedList list = new LinkedList(); 内部声明了Node类型的first和last属性，默认值为null
 *      list.add(123); // 将123封装到Node中，创建了Node对象
 *  以下内部类的定义说明了LinkedList的双向链表的说法
 *  private static class Node<E> {
 *      E item;
 *      Node<E> next;
 *      Node<E> prev;
 *
 *      Node(Node<E> prev, E element, Node<E> next) {
 *          this.item = element;
 *          this.next = next;
 *          this.prev = prev;
 *      }
 *  }
 *
 *  Vector源码
 *      默认初始化长度为10的数组
 *      每次扩容原数组的长度 * 2
 *
 * @author aCheng
 * @create 2020/08/30 下午 6:41
 */
public class _2_List {

    public static void main(String[] args) {

//        LinkedList<Object> objs = new LinkedList<>();
//        objs.add("first");
//        objs.add("two");

        Vector<Object> objects = new Vector<>(0);
        objects.add(123);
        objects.add(456);
        objects.add(789);
        objects.forEach(System.out::println);



    }
}
