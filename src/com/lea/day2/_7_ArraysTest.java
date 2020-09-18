package com.lea.day2;

import java.util.Arrays;

/**
 * @author a cheng
 * @create 2020/8/1 17:32
 * arrays工具类的使用
 */
public class _7_ArraysTest {

    
    public static void main(String[] args) {
        int[] arr = new int[3];
        Arrays.fill(arr, 1,3,3);
        System.out.println(Arrays.toString(arr));
    }
}
