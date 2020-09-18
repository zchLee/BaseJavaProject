package com.lea.day2;

import java.util.Random;

/**
 * @author a cheng
 * @create 2020/7/27 22:41
 */
public class _2_ArrayTest {

    // 创建一个长度为6的int数组，要求数组元素值都在1-30之间 且是随机产生，同时要求各个元素不同
    public static void main(String[] args) throws InterruptedException {
        int[] nums = new int[6];
        for (int i = 0; i < nums.length; i++) {
            nums = findOnlyOne(nums, i);
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int[] findOnlyOne(int[] arr, int index) {
        Random random = new Random();
        int num = random.nextInt(30) + 1;
        for (int i1 = 0; i1 < arr.length; i1++) {
            if (arr[i1] != 0 && num == arr[i1]){
                findOnlyOne(arr, i1);
                break;
            }
        }
        arr[index] = num;
        return arr;
    }
}
