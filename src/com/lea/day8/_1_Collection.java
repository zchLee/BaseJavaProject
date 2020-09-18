package com.lea.day8;

/**
 * 一、 集合框架
 *      |---Collection接口： 单列结合，用来存储单个对象
 *          |---List接口： 存储有序的、可重复的数据                   ---》“动态”数组
 *              |--- ArrayList    线程不安全，但是效率高，底层使用object[] elementData数组存储
 *              |--- LinkedLisvt  频繁增加或删除使用此类效率比ArrayList高，使用双向链表结构
 *              |--- Vector       线程安全 底层使用object[] elementData数组存储
 *          |---Set接口： 无序、不可重复的数据                       ---》集合
 *              |--- HashSet、LinkedHashSet、TreeSet
 *
 *      |---Map接口： 双列集合，用来存储一对（key、value）一对的数据     ---》映射《键值对》
 *          |---HashMap、linkedhashMap、TreeMap、HashTable、Properties
 *
 * @author aCheng
 * @create 2020/08/21 下午 5:12
 */
public class _1_Collection {
}
