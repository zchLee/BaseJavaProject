package com.lea.day3;

/**
 * @author a cheng
 * @create 2020/8/3 20:11
 */

/**
 * 方法重载（overload）
 * 一个类中允许存在同名的方法，但形参不同，与方法、返回类型、权限修饰符无关
 */
public class _4_Overload {

    public static void main(String[] args) {
        strings(args);
    }


    public static void strings(String... arg){
        System.out.println();
    }

    public void sort(int[] array){

    }

    public void sort(String[] array){

    }

//    public int sort(String[] array){
//        return 0;
//    }
//
//
//    private int sortString[] array){
//        return 0;
//    }

}
