package com.lea.day12;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 反射机制
 * // 疑问1：通过反射或new的方式都可以调用公共的结构，开发中用哪个？
 *        new 方便、简洁
 *         什么时候用到反射。 反射的特征：动态性
 *
 * // 疑问2：反射机制与面向对象中的封装性是不是矛盾的？如何看待这两个技术?
 *    反射是一种机制，是动态调用的
 *
 *
 *    Class实例对应加载到内存中的一个可运行时类。
 *
 * @author aCheng
 * @create 2020/09/10 下午 1:57
 */
public class _1_Reflection {


    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<Person> clazz = Person.class;
        // 1.通过反射，穿件Person类的对象
        Constructor<Person> cons = clazz.getConstructor(String.class, int.class);
        Person p = cons.newInstance("tom", 12);
        System.out.println(p);
        // 2.通过反射、调用对象指定的属性、方法
        Field age = clazz.getField("age");
        age.set(p, 23);
        System.out.println(p);
        // 获取方法
        Method show = clazz.getMethod("show");
        // 调用方法
        show.invoke(p);
        System.out.println(p);


        System.out.println("***********************");
        Constructor<Person> cons1 = clazz.getConstructor(String.class);
        // 屏蔽修饰符权限，使构造器能直接方法priva修饰的成员属性或方法
        cons1.setAccessible(true);
        Person p2 = cons1.newInstance("liam");
        System.out.println(p2);

        // 调用私有属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p2, "tom");
        System.out.println(p2);

        // 调用私有方法
        Method showNation = clazz.getMethod("showNation", String.class);
        showNation.setAccessible(true);
        showNation.invoke(p2, "中国");

    }

     /*
    关于java.lang.Class类的理解
    1.类的加载过程：
    程序经过javac.exe命令以后，会生成一个或多个字节码文件(.class结尾)，
    接着使用java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件加载到内存中。此过程就称为类的加载。
    加载到内存中的类，我们就称为运行时类，此运行时类，就作为Class的一个实例

    2.换句话说，Class的实例就对应着一个运行时类。

    3.加载到内存中的运行时类，会缓存一定的时间，在此时间内，可以通过不同方式获取此运行时类，
            且类地址是一致的
     */
    // 获取Class实例的方式。类，接口，枚举，基本数据数据类型，void，Class，数组（数组类型和维度一致，就是同一个Class）等都能获取运行时类
    @Test
    public void test2() throws ClassNotFoundException {
        // 方式一： 调用运行时类的属性：class
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);

        // 方式二： 通过运行时类的对象 getClass() 方法获取
        Person person = new Person();
        Class clazz2 = person.getClass();
        System.out.println(clazz2);

        // 方式三：调用Class的静态方法 Class.getName(String classPath);
        Class clazz3 = Class.forName("com.lea.day12.Person");
//        clazz3 = Class.forName("java.lang.String");
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);

        // 方式四：使用类的加载器：ClassLoader
        // 获得当前类的ClassLoader对象，再加载其他类全路径，获得Class运行时类
        ClassLoader classLoader = _1_Reflection.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("com.lea.day12.Person");
        System.out.println(clazz4);
        System.out.println(clazz1 == clazz4);
    }
}
