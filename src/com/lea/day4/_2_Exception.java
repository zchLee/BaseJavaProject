package com.lea.day4;

/**
 * @author aCheng
 * @create 2020/8/16 14:41
 *
 *
 * 异常体系结构
 *  java.lang.Throwable
 *     --- java.lang.Error:一般不编写针对性代码进行处理
 *     ---- java.lang.Exception: 可以进行异常的处理
 *          --- 编译时异常（checked）
 *                  -- IOException
 *                      --FileNotFindException
 *          --- 运行时异常 （unchecked）RuntimeException
 *                  -- NullpointException
 *                  -- ArrayIndexOutOfBoundsException
 *                  -- ClassCastException
 *                  -- NumberFormatException
 *
 *  异常处理的抓抛模型
 *      过程一： “抛” 程序执行中，一旦出现异常，就会在异常代码处生成一个异常对象，并将其抛出，
 *          一旦抛出，一下代码不会继续进行
 *          语法： 在方法名后加 throws Exception
 *          public void method throws Exception() {};
 *
 *          系统自己生成的异常
 *          用throw new xxxException() 抛出
 *      过程二 ： 在方法体中的处理方式
 *        异常处理方式:
 *          try{
 *
 *          } catch(Exception e){
 *
 *          }finally{
 *
 *          };
 *         2. throw New Exception();
 * Spring 事务中默认处理RuntimeException异常，所以要明确的写异常回滚类型 Exception
 */
public class _2_Exception {
}
