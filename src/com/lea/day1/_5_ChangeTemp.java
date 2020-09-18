package com.lea.day1;

/**
 * @author a cheng
 * @create 2020/7/25 19:59
 */
public class _5_ChangeTemp {

    // 交换临时变量
    public static void main(String[] args) {
        int n1 = 18;
        int n2 = 27;
        System.out.println(String.format("n1 = %d, n2 = %d", n1, n2));
        // 方式一 定义临时变量
//        int temp = n1;
//        n1 = n2;
//        n2 = temp;
        // 方式二 不用临时变量  如果数够大，会损失精度， 看第三种方法
//        n1 = n1 + n2;
//        n2 = n1 - n2;
//        n1 = n1 - n2;
        // 方式三
        n1 = n1 ^ n2;
        n2 = n1 ^ n2;
        n1 = n1 ^ n2;
        System.out.println(String.format("n1 = %d, n2 = %d", n1, n2));
    }
}
