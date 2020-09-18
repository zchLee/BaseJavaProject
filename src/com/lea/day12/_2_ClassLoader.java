package com.lea.day12;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * 当程序主动使用某个类时，如果该类还未加载到内存中，则系统会通过如下步骤来对该类进行初始化
 *
 *  类的加载                    类的链接                类的初始化
 * （Load）                   （Link）               （Initialize）
 *  将类的class文件读入内存      将类的二进制数据合并到     JVM负责对类进行初始化
 *  并为之创建一个java.lang     JRE中
 *  .Class对象。此过程由类加载
 *  器完成
 *
 * 1.加载：
 *  将class文件字节码内容加载到内存中，并将这些静态数据转换成方法区的运行时数据结构，
 *  然后生成一个代表这个类的java.lang.Class对象，作为方法区中类数据的访问入口（即引用地址）。
 *  所需要访问和使用类数据只能通过这个Class对象。这个加载的过程需要类加载器参与。
 * 2.链接：将Java类的二进制代码合并到JVM的运行状态之中的过程。
 *      验证：确保加载的类信息符合JVM规范，例如：以cafe开头，没有安全方面的问题
 *      准备：正式为类变量（static）分配内存并设置类变量默认初始值的阶段，这些内存都将在方法区中进行分配
 *      解析：虚拟机常量池内的符号引用（常量名）替换为直接引用（地址）的过程
 * 3.初始化：
 *      3.1执行类构造器<clinit>()方法的过程。类构造器<clinit>()方法是由编译期自动收集类中的所有类的变量的赋值动作和静态
 *          代码块中的语句合并产生。(类构造器是构造类信息的，不是构造该类对象的构造器)
 *      3.2 当初始化一个类的时候，如果发现其父类没有进行初始化，则需要先触发其父类的初始化
 *      3.3虚拟机会保证一个类的<clinit>()方法在多线程环境中被正确加锁和同步
 *
 *
 * 类加载器的作用：
 *  类加载的作用：将class文件字节码内容加载到内存中，并将这些静态数据转换成方法区的运行时数据结构，然后在堆中生成一个代表这个
 *      类的java.lang.Class对象，作为方法区中类数据的访问入口
 *  类缓存：标准的JavaSE类加载器可以按要求查找类，但一旦某个类被加载到类加载器中，它将维持加载一段时间。不过JVM垃圾回收机制
 *      可以回收这些Class对象
 *
 *
 * @author aCheng
 * @create 2020/09/10 下午 4:15
 */
public class _2_ClassLoader {
    
    @Test
    public void test() {
        // 对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = _2_ClassLoader.class.getClassLoader();
        System.out.println(classLoader);
        // 扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);
        // 引导类加载器（不可获得，处理java核心类库类加载，无法加载自定义类）
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);
    }


    @Test
    public void test1() throws IOException {
        Properties properties = new Properties();
        // 测试方法，相对路径指，当前module
        // main方法，相对路径指 当前project
//        FileInputStream is = new FileInputStream("jdbc.properties");

        // 从类加载器上获取输入流，相对路径指 当前module的src文件下
        InputStream is = _2_ClassLoader.class.getClassLoader().getResourceAsStream("com/lea/day12/jdbc1.properties");

        properties.load(is);

        String name = properties.getProperty("name");
        String pwd = properties.getProperty("pwd");
        System.out.println("name:" + name + "  " + "pwd:" + pwd);
    }
}
