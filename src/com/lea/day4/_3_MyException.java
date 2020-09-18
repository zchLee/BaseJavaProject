package com.lea.day4;

/**
 * @author aCheng
 * @create 2020/8/16 15:59
 *
 *  Exception 是编译时异常，继承或抛出异常父类为Exception时，方法体必须处理或者继续抛出
 *
 *  RuntimeException 是运行时异常，可以不显示的处理异常，但是运行时报错就会使程序终止
 *
 *      简单说来 Exception 编译期就必须处理，否则编译不通过，
 *  RuntimeException 编译器可以不处理，但是运行时可能会报错，终止程序
 *
 *
 *  如何自定义异常类？
 *  1. 继承已有的异常结构： Exception 或 RuntimeException
 *  2. 提供序列号(serialVersionUID)
 *  3. 提供重载构造器
 *
 */
public class _3_MyException extends RuntimeException {

    private static final long serialVersionUID = -6226474613060557531L;

    public _3_MyException() {}

    public _3_MyException(String message) {
        super(message);
    }

}
