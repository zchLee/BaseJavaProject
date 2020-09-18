package com.lea.day8;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

/**
 * |---Map:双列数据：映射，存储key-value对的数据，  ---类似高中函数 y=f(x);
 *      |---HashMap: Map主要实现类，线程不安全 效率高，key、value可以为null
 *          |---LinkedHashMap: 保证在遍历map元素时，可以添加的顺序实现遍历，
 *              原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素
 *              频繁遍历时，LinkedHashMap速度快
 *      |---TreeMap： 按照添加进去的key-value对进行排序，实现排序遍历。是考虑key的排序规则
 *      底层使用红黑树
 *      |---HashTable： jdk1.0出现，线程安全 效率低 key、value不能为null
 *      |---Properties: 常用来处理配置文件。key和value都是String类型
 * <p>
 * HashMap底层：数组+链表 jdk1.7及以前
 * 数组+链表+红黑树 jdk1.8
 * 面试题：
 * 1.HashMap的底层实现原理
 * 2.HashMap与HashTable的区别
 * 3.CurrentHashMap与HashTable的区别
 * <p>
 * 二、Map结构的理解：
 * Map中的key:无序、不可重复，使用Set存储所有key
 * Map中的value：无序、可重复 使用Collection存储所有的value
 * 一个键值对：key：value构成了一个Entry对象
 * Map中的entryy：无序、不可重复、使用Set存储所有的entry
 *
 * DEFAULT_INITIAL_CAPACITY     默认初始容量 16
 * MAXIMUM_CAPACITY             最大容量 2^30
 * DEFAULT_LOAD_FACTOR          默认加载因子 0.75
 * TREEIFY_THRESHOLD            Bucket中链表长度大于该默认值，转化成红黑树
 * UNTREEIFY_THRESHOLD          Bucket中红黑树存的的Node小于默认值，转换成链表
 * MIN_TREEIFY_CAPACITY         桶中的Node被树华时最小的hash容量。（当桶中Node的数量大到需要红黑树时，若hash表容量小与MIN_TREEIFY_CAPACITY
 *                              时，应该执行resiz()扩容操作这个MIN_TREEIFY_CAPACITY的值至少是TREEIFY_THRESHOLD的四倍）
 *
 * table：存储元素的数组。总是2的n次幂
 * entrySet：存储具体元素的集合
 * size：HashMap中存储的键值对的数量
 * modCount：HashMap扩容和结构改变的次数
 * threshold: 扩容的临界值，=容量*填充因子
 * loadFactor：填充因子
 *
 *
 * @author aCheng
 * @create 2020/08/31 下午 6:35
 */
public class _4_Map {

    /*
    jdk7 HashMap底层实现原理
    在实例化以后，底层创建了长度是16的以为数组Entry[] table;
    ...多次执行...
    map.put(key1,value1);
    首先，调用key1所在类的hashCode() 计算key1哈希值。此哈希值经过某种算法计算以后，得到在Entry数组中的存放位置。
    如果此位置上没有数据，那么Entry插入成功                                   ---case 1
    如果此位置有数据（以为着此位置上存在一个或多个数据(以链表形式存在)），比较key1和已经存在的一个或多个数据的哈希值
          如果key1的哈希值与已经存在的数据的哈希值不一样，entry添加成功           ---case 2
          如果key1的哈希值和已经存在的某一个数据(key2-value2)的哈希值相同，继续比较:调用key1的equals(key2)
                如果equals()返回false：此时key-value添加成功               ---case 3
                如果返回true：将新添加的value 替换 旧value

     补充：关于情况2和情况3：此时key1-value和原来的数据以链表形式存在

     在不断添加过程中，会涉及到扩容问题，当超出临界值时，且索引位置有数据，调用resiz()扩容，扩容以前的两倍
     */
    @Test
    public void test() {
        HashMap<Object, Object> hashMap = new HashMap<>();
        Object key1 = hashMap.put("fdsafsd", "ewqeq");
        Object key2 = hashMap.put("fdsafsd", "ewqeq");
    }


    /*
    jdk8相较于jdk7底层实现不同：
        1.new HashMap():底层没有创建一个长度为16的数组；
        2.jdk 8 底层数据时Node[], 非Entry[]
        3.首次调用put(key,value),则底层创建长度为16的数组
        4.jdk7 底层结构只有数组+链表，jdk8中有数组、链表和红黑树
            当数组的某一个索引位置上的元素以链表形式存在的数组个数 > 8 且当前数组的长度 > 64
                ,此时此索引上的所有数据改为使用红黑树存储

         DEFAULT_INITIAL_CAPACITY     默认初始容量 16
         DEFAULT_LOAD_FACTOR          默认加载因子 0.75
         hreshold:                    扩容的临界值，=容量*填充因子
         TREEIFY_THRESHOLD            Bucket中链表长度大于该默认值，转化成红黑树
         UNTREEIFY_THRESHOLD          Bucket中红黑树存的的Node小于默认值，转换成链表
         MIN_TREEIFY_CAPACITY        64 桶中的Node被树华时最小的hash容量。（当桶中Node的数量大到需要红黑树时，若hash表容量小与MIN_TREEIFY_CAPACITY
 *                              时，应该执行resiz()扩容操作这个MIN_TREEIFY_CAPACITY的值至少是TREEIFY_THRESHOLD的四倍）
     */
    @Test
    public void test1() {
        HashMap<Object, Object> hashMap = new HashMap<>();
        Object key1 = hashMap.put("fdsafsd", "ewqeq");
        Object key2 = hashMap.put("fdsafsd", "ewqeq");

        // 遍历方式1
        Set<Object> keys = hashMap.keySet();
        for (Object o: keys){
            System.out.println(o);
        }
        // 遍历方式2
        Collection<Object> values = hashMap.values();
        for (Object value : values) {
            System.out.println(value);
        }
        // 遍历方式3
        Set<Map.Entry<Object, Object>> entrySet = hashMap.entrySet();
        for (Map.Entry<Object, Object> entry : entrySet) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }


    /*
    LinkedHashMap:
    源码中：重新定义一个静态内部类，重写了HashMap类中的newNode方法
        static class Entry<K,V> extends HashMap.Node<K,V> {
            Entry<K,V> before, after;       // 维护前一个、后一个Entry对象 能记录添加元素的先后顺序
            Entry(int hash, K key, V value, Node<K,V> next) {
                super(hash, key, value, next);
            }
        }
     */
    @Test
    public void linkedHashMap() {
        new LinkedHashMap<>();
    }

    /*
    TreeMap:
        key必须是同一个类的对象,排序相同的数据会替换原有的数据
           按排序规则存放
                   1. 自然排序
                   2. 定制排序
     */
    @Test
    public void treeMap() {
        final Object p = new Object();
        TreeMap<Object, Object> treeMap = new TreeMap<>();
        treeMap.put(432, p);
        treeMap.put(123, p);
        treeMap.put(32, p);
        treeMap.put(765, p);
        treeMap.put(3753, p);
        treeMap.put(1, p);
        treeMap.put(1, "2");
        treeMap.put(1, "3");
        for (Object k: treeMap.keySet()) {
            System.out.println(k + "---->" + treeMap.get(k));
        }
    }

    /*
    Properties
     */
    @Test
    public void properties() {
        Properties pro = new Properties();
        try {
            pro.load(new FileInputStream("jdbc.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 遍历方式1
        Enumeration<Object> keys = pro.keys();
        while ( keys.hasMoreElements()) {
            Object o = keys.nextElement();
            System.out.print(o);
            System.out.print("--------->");
            System.out.println(pro.getProperty(o.toString()));
        }

        // 遍历方式二
        Set<Object> objects = pro.keySet();
        for (Object o : objects) {
            System.out.println(o);
        }

        // 遍历方式三
        Collection<Object> cs = pro.values();
        for (Object o : cs) {
            System.out.println(o);
        }
        // 遍历方式四
        Set<Map.Entry<Object, Object>> entries = pro.entrySet();
        for (Map.Entry<Object, Object> o : entries) {
            System.out.println(o.getKey() + "  " + o.getValue());
        }

    }
}
