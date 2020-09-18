package com.lea.day9;

/**
 * @author aCheng
 * @create 2020/09/02 上午 10:45
 */
public class SubMyGeneric1 extends _2_MyGeneric<Order> {
    // 继承一个泛型类 不重新定义泛型，需要指明继承泛型类的具体泛型类型，此类也不是一个泛型类
    /*
    子类不保留父类泛型
        没有类型 擦除 SubMyGeneric1 extends _2_MyGeneric
        具体类型  SubMyGeneric1 extends _2_MyGeneric<Order>
     */
}
