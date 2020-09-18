package com.lea.day7;

/**
 * @author aCheng
 * @create 2020/08/21 下午 4:10
 */
/*
 1.@interface 注解声明为@interface
 2. 自动继承java.lang.annotation.Annotation接口
 3. Annotation的成员变量在Annotation定义中以无参方法的形式来声明。其方法名和返回值定义了该成员的名字和类型。
    我们称为配置参数。类型只能是八种基本数据类型、String类型、Class 类型、enum类型、Annotation类型
    、以上所有类型的数组
 4. 可以在定义Annotation的成员变量时为其指定初始值，指定成员变量的初始值可以用default关键字
 5. 如果只有一个参数成员，建议使用参数名为value
 6.如果定义的注解含有配置参数，那么使用时必须指定参数值，除非它有默认值。格式是：“参数名=参数值”，如果只有一个参数成员，
    且名称为“value”，可以省略“value=”
 7.没有成员定义的Annotation称为 标记 ；包含成员变量的Annotation称为元数据Annotation


 二、（四个）jdk内置的元注解 --> 对现有的注解进行解释说明的注解
    Retention  只能用来修饰Annotation定义，用于指定该Annotation的生命周期，
        @Retention包含一个RetentionPolicy类型的成员变量，使用@Retention时必须给value值赋值
        RetentionPolicy.SOURCE:在源文件中有效（即：在源文件中保留），编译器直接丢弃这种策略的注释
            编译器结束就结束了
    默认 RetentionPolicy.CLASS:在class文件中有效（即：在class保留），当运行java程序时，JVM不会保留注释。这是默认值
            class文件中有此注解，不会加载到内存中，运行时不会有这个注解
        RetentionPolicy.RUNTIME:在运行时有效（即运行时保留），当运行java程序时，JVM会保留注释。程序可以通过反射获取该注释
            运行时还存在，加载到内存中了

    Target: 用于修饰Annotation定义，用于指定修饰的Annotation能用于修饰哪些元素，@Target包含一个名为value的成员变量
        CONSTRUCTOR:用于构造器
        FILED: 用于描述域
        LOCAL_VARIABLE：用于描述局部变量
        METHOD: 用于描述方法
        PACKAGE：用于描述包
        PARAMETER: 用于描述参数
        TYPE：用于描述类、接口（包括注解类型）或enum声明
    ****************************************************************************
    Documented ：用于指定该元Annotation修饰的Annotation类被javadoc工具提取成文档，默认情况下javadoc是不包括注解的
            定义该注解必须设置Retention值为RUNTIME
    Inherited：被修饰的类将具有 继承性 。 如果某个类使用了被@Inherited修饰的Annotation，则其子类将自动具有该注解

   三、 jdk8注解新特性：可重复注解、类型注解
        可重复注解： 在注解中定义数组注解
 */

//@Retention(RetentionPolicy.RUNTIME)
//@Repeatable()
public @interface _3_MyAnnotation {

    String value() default "hello";
    // jdk8之前可重复注解写法
//    _3_MyAnnotation[] value();
}
