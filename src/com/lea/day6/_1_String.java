package com.lea.day6;

/**
 *  String的使用
 *
 * @author aCheng
 * @create 2020/08/19 下午 2:14
 */
public class _1_String {

    /*
    1.String被final修饰，不可被继承
    2.String实现Serializable接口：表示字符串支持序列化
            实现Comparable接口：表示字符串可以比较大小
    3.String内部定义了final char[] value 用于存储字符串数据
    4.String代表不可变的字符序列。简称 不可变
        体现： 1.当对字符串重新赋值时，需要重写指定内存区域赋值，不能使用原有的value进行赋值
              2.当对现有的字符串进行连接操作时，也要重新指定内存区域赋值，不能使用原有的value进行赋值
    5.通过字面量的方式给一个字符串赋值，此时的字符串值声明在字符串常量池中。
    6.字符串常量池中是不会存储相同的内容的字符串的

     常量与常量的拼接结果在常量池，且常量池中不会存在相同内容的常量
     只要其中有一个是变量，结果在堆中
     如果拼接的结果是调用inter()方法，放回值就在常量池中
     */
    public static void main(String[] args) {
        // 字面量赋值
        String i = "abc";
        String j = "def";
        String n1 = "abc" + "def";
        String n2 = i + "def";
        String n3 = "abc" + j;
        String n4 = i + j;
        String n5 = (i + j).intern();
        System.out.println(n1 == n2);
        System.out.println(n1 == n3);
        System.out.println(n1 == n4);
        System.out.println(n1 == n5);

        System.out.println(String.valueOf(i.charAt(0)).toUpperCase());

        StringBuffer sb = new StringBuffer();
        sb.length();
        sb.append(2);
    }

}
