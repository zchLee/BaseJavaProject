package com.lea.day13;

import com.lea.day12.Creature;
import com.lea.day12.Person;
import com.lea.day12.Persons;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 1.当要传递给lambda体的操作。已经有实现方式了。可以使用方法引用。方法引用可以看做Lambda表达式深层次的表达。
 *  换句话说方法引用就是lambda
 *
 * 2.方法引用，本质上是lambda表达式，而lambda表达式作为函数式接口的实例。所以方法引用，也是函数式接口的实例
 *
 * 3.使用格式： 类（或对象） :: 方法名
 *
 * 4.具体分为如下三类
 *  对象 :: 非静态方法
 *  类  :: 静态方法
 *  类  :: 非静态方法
 *
 * 5. 方法引用使用的要求，要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的形参列表和返回值类型
 *
 * @author aCheng
 * @create 2020/09/12 上午 9:23
 */
public class _3_MethodReference {

    // 对象 :: 非静态方法
    @Test
    public void test() {
        PrintStream out = System.out;
        Consumer<String> con = out :: println;
        con.accept("对象调用非静态方法");
    }


    // 类 :: 静态方法
    @Test
    public void test1() {
        Comparator<Integer> com = (o1, o2) -> Integer.compare(o1, o2);

        // 方法引用 (引用类型与实例化函数式接口的参数类型、个数和返回值类型一致)
        com = Integer::compareTo;
        System.out.println(com.compare(23, 8));
    }

    /*
    Function<R, T>函数式接口，
      方法  T apply(R) 传入R类型参数，返回T类型数据
     */
    @Test
    public void test2() {
        Function<Double, Long> func = (d) -> Math.round(d);
        Long apply = func.apply(9.5);
        System.out.println(apply);

        System.out.println("-----------------------------");

        Function<Double, Long> func1 = Math::round;
        System.out.println(func1.apply(9.4));

    }



    // 类 :: 实例方法
    /*
    Comparator中的int compare(T o1, T o2);
    String中的int compareTo(String anotherString)
     */
    @Test
    public void test3() {
        Comparator<String> com = (o1, o2) -> o1.compareTo(o2);

        // 函数式接口和实现类参数类型不一致，
        // 但是实现类是用函数式接口中一个参数调用另一个参数，得到返回结果，返回类型一致
        // 此时就可以直接用 类::实例方法
        com = String::compareTo;
        System.out.println(com.compare("abc", "abd"));
    }

    /*
    BiPredicate boolean test(T t, U u);
    String中的boolean equals(Object anObject)
     */
    @Test
    public void test4() {
        BiPredicate<String, String> predicate = (s1, s2) -> s1.equals(s2);

        // 函数式接口和实现类参数类型不一致，
        // 但是实现类是用函数式接口中一个参数调用另一个参数，得到返回结果，返回类型一致
        // 此时就可以直接用 类::实例方法
        predicate = String::equals;
        System.out.println(predicate.test("abc", "abd"));
    }

    @Test
    public void test5() {
        Persons persons = new Persons("jack", 23);
        // 传入T类型返回R类型函数式接口
        Function<Persons, String> function = p -> p.showName();

        // 函数式接口和实现类参数类型不一致，
        // 但是实现类是用函数式接口中一个参数调用另一个参数，得到返回结果，返回类型一致
        // 此时就可以直接用 类::实例方法
        function = Persons::showName;
        System.out.println(function.apply(persons));
    }

    /*
    构造器引用
        函数式接口的抽象方法的形参列表，和构造器的形参列表一致，返回值类型即为构造器的类型
     */
    @Test
    public void constructorReference() {
        Supplier<Persons> supplier = () -> new Persons();
        // 构造器引用
        supplier = Persons::new;
        Persons persons = supplier.get();
        System.out.println(persons);

        Function<Integer, Persons> function = Persons::new;
        System.out.println(function.apply(23));

        BiFunction<String, Integer, Persons> biFunction = Persons::new;
        Persons jon = biFunction.apply("jon", 23);
        System.out.println(jon);
    }

    /*
    把数组看做一个特殊的类，则写法与构造器引用一致
     */
    @Test
    public void arrayReference() {
        Function<Integer, String[]> func = length -> new String[length];
        String[] arr1 = func.apply(8);
        System.out.println("arr1 = " + Arrays.toString(arr1));
        // 数组引用
        func = String[]::new;
        System.out.println(Arrays.toString(func.apply(5)));
    }

}
