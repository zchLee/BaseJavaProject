package com.lea.day2;

/**
 * @author a cheng
 * @create 2020/7/30 21:03
 */
public class _5_BubbleSort {

    public static void main(String[] args) {
        int[] nums = new int[]{23,1,42,5,77,34,41,9,21,54};
        // 冒泡排序
        /*
         *  遍历n轮数组，比较相邻的两个数 大的往后排，直到排到最后，n-1轮的比较忽略最后已排序的数
        */
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
        }
    }
}
