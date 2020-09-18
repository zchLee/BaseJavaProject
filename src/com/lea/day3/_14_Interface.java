package com.lea.day3;

/**
 * @author aCheng
 * @create 2020/8/13 13:35
 *  1. 接口使用interface定义
 *  2. java中，接口和类是并列的两个结构
 *  3. 定义接口 ： 定义接口的成员
 *    3.1 JDK 1.7 以前：
 *          只能定义全局常量和抽象方法
 *              > 全局常量 public static final
 *              > 抽象方法： public abstract
 *     3.2 JDK 1.8
 *              > 除了定义全局常量和抽象方法，还可以定义默认方法、静态方法
 *  *  接口和类是平列
 *
 *  4. 接口中不能定义构造器！ 意味着接口不可以实例化
 *  5. java开发中，接口通过让类去实现（implement）的方式来使用
 *      如果实现类覆盖了接口中所有的抽象方法，那么实现类就可以实例化
 *      如果实现类没有全部覆盖接口中所有的抽象方法，则实现类仍为一个抽象类
 *  6. java 类可以多实现接口 弥补了单继承性的局限
 *  7. 接口与接口之间能多继承
 *
 *  8. 接口的具体实现 体现了多态
 *  9. 接口，实际上可以看做一种规范
 *
 *
 *  面试：抽象类和接口有什么区别？
 *      相同：
 *          1.不可以实例化；都可以包含抽象方法
 *      不同：抽象类可以有构造器；jdk8可以有默认方法、静态方法、jdk9可以有私有方法；
 *          抽象类智能单继承，接口可以多实现
 */
public class _14_Interface {

    public static void main(String[] args) {

        // 匿名实现类
        new Flyable(){
            @Override
            public void fly() {

            }

            @Override
            public void stop() {

            }
        };

    }

}

interface JDK8 {

//    jdk8 可以有静态方法和默认方法
   // 静态方法： 只能接口用类.method 来调用
   static void method(){
       System.out.println("静态方法");
   }

    // 默认方法 : 只能用子类来调用
   default void defaultMethod(){
       System.out.println("默认方法");
   };


}

interface Flyable {
    // 全局常量
    int MIN_SPEED = 1; // 接口中全局变量省略public static final

    // 抽象方法 省略 public abstract
    void fly();

    public abstract void stop();


}

interface AA {

}


interface Kite extends Flyable,AA {

}
