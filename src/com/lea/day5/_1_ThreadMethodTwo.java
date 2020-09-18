package com.lea.day5;

/**
 * @author aCheng
 * @create 2020/08/16 下午 8:55
 *
 *  创建线程第二种方法
 *   实现Runable接口 重写run方法
 *
 *  优先使用此方式创建线程，
 *    1、没有类的单继承性的局限性
 *    2、属性共享，更适合处理多个线程共享数据的情况
 */
public class _1_ThreadMethodTwo{

    public static void main(String[] args) {
        RunableTest runableTest = new RunableTest();
        Thread thread = new Thread(runableTest);
        thread.start();
    }

}

class RunableTest implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
             if (i % 2 == 0) {
                 System.out.println(Thread.currentThread().getName() + " : " + i);
             }
        }
    }
}
