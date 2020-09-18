package com.lea.day13;

import com.lea.day12.Person;
import com.lea.day12.Persons;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 1.Stream关注的是对数据的运算，与CPU打交道
 *      集合关注的是数据的存储，与内存打交道
 * 2.
 *   stream自己不会存储元素
 *   stream不会改变数据源对象，想反，他们会返回一个持有结果的新Stream
 *   stream是延迟执行的，这以为着他们会等到需要结果时才会被执行
 *
 * 3.Stream执行流程
 *  ① Stream实例化
 *  ② 一系列的中间操作（filter、map）
 *  ③ 终止操作
 *
 * 4.说明：
 *   4.1 一个中间操作链，对数据源的数据进行处理
 *   4.2 一旦执行终止操作，就执行中间操作链，并产生结果，之后再被使用
 * @author aCheng
 * @create 2020/09/12 下午 2:56
 */
public class _4_StreamAPI {
    private static List<Persons> list = null;

    static {
        list = new ArrayList<Persons>();
        list.add(new Persons("tom", 17));
        list.add(new Persons("jon", 21));
        list.add(new Persons("jack", 16));
        list.add(new Persons("tony", 24));
        list.add(new Persons("mac", 25));
        list.add(new Persons("liam", 16));
        list.add(new Persons("sony", 27));
    }

    // 创建Stream方式一：通过集合
    @Test
    public void test1() {
        // 返回一个顺序流
        Stream<Persons> stream = list.stream();

        // 返回一个并行流
        Stream<Persons> personsStream = list.parallelStream();
    }

    // 创建Stream方式二：通过数组
    @Test
    public void test2() {
        int[] ints = {2, 3, 6};
        // Stream<T> stream(T[] array) 返回一个顺序流
        IntStream stream = Arrays.stream(ints);

    }


    // 创建Stream方式三：通过stream的of()
    @Test
    public void test3() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 45, 6, 67);
    }

    // 创建Stream方式三：创建无限流
    @Test
    public void test4() {
        // 迭代
        // Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        // 遍历生成10个偶数
        Stream.iterate(0, t -> t+2).limit(10).forEach(System.out::println);

        // 生成
        //  Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

    /*
    Stream的中间操作
        1.筛选与切片
     */
    @Test
    public void test5() {
//        filter(Predicate<? super T> predicate);   接受lambda，从流中排除某些元素
        // 查询年纪大于3的
        list.stream().filter(p -> p.getAge() > 3).forEach(System.out::print);
        System.out.println();

//        limit(long maxSize);                      截断流，使元素不超过给定数量
        // 返回第一条
        list.stream().limit(1).forEach(System.out::print);
        System.out.println();

//        skip(long n);             跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个元素，则返回第一个空流
        // 跳过前十个数据
        list.stream().skip(3).forEach(System.out::print);
        System.out.println();

//        distinct()                筛选，通过流所产生元素的hashCode() 和 equals() 去除重复元素
        // 去除重复数据
        list.stream().distinct().forEach(System.out::print);
        System.out.println();

        System.out.println();
//        Stream<Persons> stream = list.stream();
    }


    /*
    Stream的中间操作
        2.映射
     */
    @Test
    public void test6() {
        HashMap<String, Object> data = new HashMap<>();
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd", "ee", "ff");
//        map(Function<? super T, ? extends R> mapper); 接受一个函数，将元素转换成其他形式或提取信息，该函数会被应用到每个元素上，并映射成一个新元素
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
        System.out.println();
        // 获取名字长度大于3的人的名字
        _4_StreamAPI.list.stream().filter(p -> p.getName().length() > 3).map(Persons::getName).forEach(System.out::println);

//        mapToLong(ToLongFunction<? super T> mapper)
//        mapToInt(ToIntFunction<? super T> mapper);
//        mapToDouble(ToDoubleFunction<? super T> mapper);
//        flatMap(Function<? super T, ? extends Stream<? extends R>> mapper); 接受一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
        // 类似addAll方法
        Stream<Character> characterStream = list.stream().flatMap(_4_StreamAPI::fromStringToStream);
        characterStream.forEach(System.out::println);

    }

    public static Stream<Character> fromStringToStream(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (char c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    };

    /*
    Stream的中间操作
        3.排序
     */
    @Test
    public void test7() {
        // 自然排序
        list.stream().sorted().forEach(System.out::println);

        System.out.println();

        // 自定义排序
        list.stream().sorted((p1, p2) -> p2.getAge() - p1.getAge()).forEach(System.out::println);
    }


    /*
    Stream的终止操作
        1.匹配与查找
     */
    @Test
    public void test8() {
        // allMatch(Predicate<? super T> predicate);    检查是否匹配所有元素
        // 是否所有人都大于18岁
        boolean b = list.stream().allMatch(p -> p.getAge() > 18);
        System.out.println(b);

//        anyMatch(Predicate<? super T> predicate);     检查是否至少匹配一个元素
        boolean b1 = list.stream().anyMatch(p -> p.getAge() > 18);
        System.out.println(b1);

//        noneMatch(Predicate<? super T> predicate);    检查是否没有匹配所有元素
        boolean b2 = list.stream().noneMatch(p -> p.getName().contains("d"));
        System.out.println(b2);

//        findFirst();                                  返回第一个元素
        Optional<Persons> first = list.stream().findFirst();
        System.out.println(first);

//        findAny();                                    返回当前流中的任意元素
        Optional<Persons> findAny = list.parallelStream().findAny();
        System.out.println(findAny);

//        cont();                                       返回流中元素的总个数
        long count = list.stream().count();
        System.out.println(count);

//        max(Comparator c);                            返回流中最大值
        Optional<Persons> max = list.stream().max((o1, o2) -> o1.getAge() - o2.getAge());
        System.out.println(max);

//        min(Comparator c);                            返回流中最小值
        Optional<Persons> min = list.stream().min((o1, o2) -> o1.getAge() - o2.getAge());
        System.out.println(min);

//        forEach(Consumer c);                          内部迭代
        list.stream().forEach(System.out::println);
    }

    /*
    Stream的终止操作
        2.归约
     */
    @Test
    public void test9() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
//        reduce(T identity, BinaryOperator<T> accumulator); 将流中元素反复结合，得到一个新的值，返回T
//        list.stream().reduce()
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);
//        reduce(BinaryOperator<T> accumulator);  将流中元素反复结合起来，得到一个新值，但是Optional<T>
        Optional<Integer> reduce1 = list.stream().reduce((i1, i2) -> i1 + i2);
        System.out.println(reduce1);
    }

    /*
    Stream的终止操作
        3.收集
     */
    @Test
    public void test10() {
        // 将流转换成其他形式，接受一个Collect接口的实现，
        // 查找年纪大于18的人
        List<Persons> collect = list.stream().filter(e -> e.getAge() > 18).collect(Collectors.toList());
        System.out.println(collect.toString());

        Set<Persons> collect1 = list.stream().filter(e -> e.getAge() > 18).collect(Collectors.toSet());
        System.out.println(collect1.toString());

        Map<String, Integer> map = list.stream().filter(e -> e.getAge() > 18).collect(Collectors.toMap(Persons::getName, Persons::getAge));
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }
    }
}
