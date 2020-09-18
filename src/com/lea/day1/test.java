package com.lea.day1;


import java.util.Scanner;

/**
 * @author a cheng
 * @create 2020/7/25 21:00
 */
public class test {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            double score = s.nextDouble();
            if (score > 90) {
                System.out.println("鸡腿");
            }else if (score > 80) {
                System.out.println("小鸡腿");
            }else if (score > 60) {
                System.out.println("面条");
            }else {
                System.out.println("棒槌");
            }
            System.out.println("成绩" + score);
            break;
        };
    }
}
