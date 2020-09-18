package com.lea.day2;

/**
 * @author a cheng
 * @create 2020/7/26 11:26
 */
public class _1_ArrayTest {
    /**  数组 是多个相同类型数据按一定顺序排列的组合，并使用一个名字命名
     *  通过索引的方式，对数组统一管理
     *
     * 特点：
     *  数组是有序的排列。
     *  数组是属于引用类型的变量。数组的元素，既可以是基本数据类型，也可以使引用类型
     *  创建数组对象会在内存中开辟一整块连续的内存空间
     *  数组的长度一旦确定，就不能修改
     *
     *  ！！基本数据类型的初始化 都是 0
     *
     *  // 静态初始化
     *         int[] ids2 = new int[]{1,2,3};
     *         // 动态初始化
     *         int[] ids = new int[2];
     */

    /**
     *  内存的简化结构
     *
     *  栈（stack） （小）：是线性结构，所以瘦， 主要存放局部变量
     *
     *  堆（heap） （大）：存放东西不规定，比较胖， new出来的对象、数组
     *
     *  方法区： 分为 常量池、静态域
     */

    /**
     * 数据结构
     * 1.数据结构与数据之间的逻辑关系：集合、一对一、一对多、多对多
     * 2.数据的存储结构
     * 线性表：顺序表（数组）、链表、栈（单出口，先进后出）、队列（双出口 先进先出）
     * 树形结构：二叉树
     * 图形结构：
     *
     *  算法
     */
    public static void main(String[] args) {
        // 杨辉三角
        int[][] arr = new int[10][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[i+1];
            arr[i][0] = arr[i][i] = 1;
            for (int j = 1; j < arr[i].length - 1; j++) {
                arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int i1 = 0; i1 < arr[i].length; i1++) {
                System.out.print(arr[i][i1] + "\t");
            }
            System.out.println();
        }
    }
}
