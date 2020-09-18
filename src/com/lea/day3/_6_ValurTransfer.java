package com.lea.day3;

import java.io.PrintStream;

/**
 * @author a cheng
 * @create 2020/8/4 18:38
 */
public class _6_ValurTransfer {

    public static void main(String[] args) {
        // 在method方法中输出 a=100 b=200
//        int a= 10;
//        int b = 20;
//        method(a, b);
//        System.out.println("a=" + a);
//        System.out.println("b=" + 20);

        int[] num = new int[3];
        char[] chars = new char[3];
        System.out.println(num);
        System.out.println(chars);
        System.out.println("da");
//        this.method(1,2);
    }

    public void method(int a, int b){
        PrintStream printStream = new PrintStream(System.out){
            @Override
            public void print(String s) {
                if ("a=10".equals(s)){
                    s = "a=100";
                }
                if ("b=20".equals(s)){
                    s = "b=200";
                }
                super.print(s);
            }
        };
        System.setOut(printStream);
    }
}
