package com.lea.day1;

/**
 * @author a cheng
 * @create 2020/7/26 10:55
 */
public class _6_BreakAndContinue {

    public static void main(String[] args) {
//        带标签 的break continue
        lable:for (int i=0; i < 9;i++){
            System.out.println("外层"+i);
            for (int j = 0; j < 5; j++) {
                System.out.println("内层"+j);
//                break lable; // 结束当代标签的循环
                continue lable; // 结束标签循环 和当前循环
            }
        }
    }
}
