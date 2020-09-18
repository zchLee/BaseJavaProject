package com.lea.day3;

/**
 * @author a cheng
 * @create 2020/8/3 20:39
 *
 * 方法形参的传递机制：值传递
 *          java里方法的参数传递方式只有一种，‘值传递’，
 *      即将实际参数值得副本，传入方法内，而参数本身不受影响 。
 *
 * 形参是基本数据类型：将基本数据类型实际存储的 `数据值` 传递给形参
 * 形参是引用数据类型： 将引用数据变量类型的 `地址值` 传递给形参, 形参改变地址值的属性，没有改变地址值，
 * 所以同一个地址值的属性就会跟着改变
 */
public class _5_ValueTransfer {

    public static void main(String[] args) {
        _5_ValueTransfer valueTransfer = new _5_ValueTransfer();
        // 基本数据类型 值传递
//        int i = 3,j = 7;
//        valueTransfer.change(i,j);
//        System.out.println(i + " " + j);

        // 引用数据类型 值传递
//        Data data = new Data();
//        data.m = 3;
//        data.n = 7;
//        System.out.println(data.m + " " + data.n);
//        valueTransfer.change(data);
//        System.out.println(data.m + " " + data.n);


        String str = "one";
        System.out.println(str);
        change(str);
        System.out.println(str);
    }

    public static void change(String str){
        // str 是拷贝值，和源数据无关。复制调用方的拷贝地址值，下方赋值操作，重新定义拷贝地址值
        // 赋值
        str = "two";
    }

    public void change(int i, int j){
        int temp = i;
        i = j;
        j = temp;
        System.out.println(i + " " + j);
    }


    public void change(Data data){
        int temp = data.n;
        data.n = data.m;
        data.m = temp;
    }
}

class Data{
    int m;
    int n;
}
