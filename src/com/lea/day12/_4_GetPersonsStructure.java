package com.lea.day12;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author aCheng
 * @create 2020/09/10 下午 6:00
 */
public class _4_GetPersonsStructure {

    // 获取类的属性
    @Test
    public void filedTest() {
        Class clazz = Persons.class;
        // 获取当前运行时类及父类中声明为public访问权限的属性
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        // 获取当前运行类中声明的所有属性。（不包含父类中声明的属性）
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
            System.out.print("\t权限修饰符：" + Modifier.toString(declaredField.getModifiers()));
            System.out.print("\t数据类型：" + declaredField.getType());
            System.out.print("\t变量名：" + declaredField.getName());
            System.out.println();
        }
    }

    @Test
    public void methodsTest() {
        Class clazz = Persons.class;
        // 获取当前类和父类 所有权限修饰符声明为public的方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("********************************************************************************");
        System.out.println("********************************************************************************");
        System.out.println("********************************************************************************");
        // 获取当前运行时类中声明的所有方法（不包含父类中声明的方法）
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods) {
            System.out.println(m);
            // 获取方法的注解
            Annotation[] annos = m.getAnnotations();
            for (Annotation a : annos) {
                System.out.print("\t" + a);
            }
            // 获取方法的权限修饰符
            System.out.println("\t" + Modifier.toString(m.getModifiers()));
            // 获取方法返回值类型
            System.out.println("\t" + m.getReturnType().getName());
            // 获取方法名
            System.out.println("\t" + m.getName());
            // 参数类型，参数名，参数个数
            Class<?>[] parameterTypes = m.getParameterTypes();
            Parameter[] parameters = m.getParameters();
            for (int i = 0; i < m.getParameterCount(); i++) {
                System.out.print("参数：" + parameterTypes[i].getName() + "\t" + parameters[i].getName());
            }
//            System.out.print("\t" + );

            Class<?>[] exceptionTypes = m.getExceptionTypes();
            for (Class<?> exceptionType : exceptionTypes) {
                System.out.print(" \t异常：" + exceptionType.getName());
            }
            System.out.println();
        }
    }

    @Test
    public void otherTest() {
        Class<Persons> clazz = Persons.class;
        // 获取当前运行类中，声明为public的构造器
        Constructor<?>[] cons = clazz.getConstructors();
        for (Constructor<?> con : cons) {
            System.out.print(con + "\t");
        }
        System.out.println();
        // 获取当前运行类中，所有构造器
        Constructor<?>[] dCons = clazz.getDeclaredConstructors();
        for (Constructor<?> c : dCons) {
            System.out.print(c + "\t");
        }
    }

    @Test
    public void getParent() {
        Class<Persons> clazz = Persons.class;
        // 获取当前运行类的父类
        Class<? super Persons> superclass = clazz.getSuperclass();
        System.out.println(superclass);

        // 获取带泛型的父类
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);

        // 获取带泛型的父类 的泛型
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        // 获取泛型
        System.out.println(((Class)paramType.getActualTypeArguments()[0]).getName());

        // 当前运行时类的所有时间接口
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> i : interfaces) {
            System.out.print(i + "\t");
        }
        System.out.println();
        Type[] genericInterfaces = clazz.getGenericInterfaces();
        for (Type gi : genericInterfaces) {
            System.out.print(gi + "\t");
        }
    }

    /*
    操作指定属性
     */
    @Test
    public void opFiled() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class<Persons> clazz = Persons.class;
        Persons persons = clazz.newInstance();
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(persons, "tom");
        System.out.println(persons);
    }

    /*
    操作指定方法
     */
    @Test
    public void opMethod() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<Persons> clazz = Persons.class;
        Persons persons = clazz.newInstance();

        Method show = clazz.getDeclaredMethod("show", String.class);
        show.setAccessible(true);
        show.invoke(persons, "中国孝感");

        // 调用静态方法
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        // 第一种调用方法
        showDesc.invoke(persons);
        // 第二种调用方法
        showDesc.invoke(null);
    }

    /*
    调用指定构造器
     */
    @Test
    public void opConstrution() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<Persons> clazz = Persons.class;
        Constructor<Persons> cons = clazz.getDeclaredConstructor(String.class);
        cons.setAccessible(true);
        Persons tom = cons.newInstance("tom");
        System.out.println(tom);
    }
}
