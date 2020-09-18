package com.lea.day2;

/**
 * @author a cheng
 * @create 2020/7/28 16:22
 */
public class _4_ArrayExer1 {

    // 数组复制、反转、
    // array1和array2的地址值一致，都指向堆空间的唯一一个数组实体
    public static void main(String[] args) {
        int[] array1,array2;
        array1 = new int[]{2,3,5,7,11,13,17,19};
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + "\t");
        }
        
        array2 = array1;
        for (int i = 0; i < array2.length; i++) {
            if (i % 2 == 0){
                array2[i] = i;
            }
        }
        System.out.println();
        System.out.println("*------------");
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] + "\t");
        }
        System.out.println();
        System.out.println("array1*------------");
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + "\t");
        }
    }
}
