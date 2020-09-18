package com.lea.day9;

/**
 * @author aCheng
 * @create 2020/09/02 上午 10:43
 */
public class SubMyGeneric<T> extends _2_MyGeneric<T> {
    // 继承一个泛型类 重新定义泛型则是一个泛型类
    /*
    子类保留父类泛型
        全部保留 SubMyGeneric<T> extends _2_MyGeneric<T>
        部分保留 SubMyGeneric<T> extends MyGeneric<Integer, T>
     */

}
