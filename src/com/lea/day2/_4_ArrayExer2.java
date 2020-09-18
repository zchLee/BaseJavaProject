package com.lea.day2;

/**
 * @author a cheng
 * @create 2020/7/28 16:22
 */
public class _4_ArrayExer2 {
    /**
     * 算法的5个特征
     * 1. 【输入】有0个或多个输入数据，这些输入必须有清楚的输出结果
     * 2. 【输出】 有1个或多个输出数据，不可以没有输出结果
     * 3. 【有穷性(有效性，Finteness)】 算法在有限步骤之内会自动结束而不是无限循环，并且每一个步骤都在可接受的时间内完成
     * 4. 【确定性(明确性，Definiteness)】 算法中的每一步都有明确的含义，不会出现二义性
     * 5. 【可行性(有效性，Effectiveness)】 算法的每一步都是清楚可行的，能让用户用纸笔计算而算出答案
     */

    // 数组复制(复制还是赋值 区别于变量的赋值是否是new的新对象)
    public static void main(String[] args) {
        int[] array1,array2;
        array1 = new int[]{2,3,5,7,11,13,17,19};

        // 数组的复制
        array2 = new int[array1.length];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = array1[i];
        }

//        for (int i = 0; i < array2.length; i++) {
//            if (i % 2 == 0){
//                array2[i] = i;
//            }
//        }


        // 数组的反转
//        for (int i = 0; i < array2.length / 2; i++) {
//            int temp = array2[i];
//            array2[i] = array2[array2.length - i - 1];
//            array2[array2.length - i - 1] = temp;
//        }

        // 遍历
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] + "\t");
        }
        System.out.println();

        // 查找
        // 线性查找：
        int dest = 7;
        boolean flag = true;
        for(int i = 0; i < array2 .length; i++){
            if (i == dest) {
                flag = false;
                System.out.println("位置在：" + i);
                break;
            }
        }
        if (flag)
            System.out.println("no info");


        // 二分查找法
        // 前提：所查找的数组必须有序
        int dest1 = 17;
        int head = 0;
        int end = array2.length - 1;
        boolean flag1 = true;
        while (head <= end) {

            int middle = (head + end) / 2;

            if (array2[middle] == dest1){
                flag1 = false;
                System.out.println("you find me!! my index is" + middle);
                break;
            }else if (array2[middle] > dest1){
                end = middle - 1;
            }else{
                head = middle + 1;
            }
        }

        if (flag1)
            System.out.println("no info.");
    }
}
