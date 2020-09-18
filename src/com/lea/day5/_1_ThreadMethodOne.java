package com.lea.day5;

/**
 * @author aCheng
 * @create 2020/8/16 17:23
 *
 *  方式一 创建多线程
 *   继承Thread类
 *
 *    继承Thread类时，同步监视器要慎用this，可能会造成多个对象过个this
 */
public class _1_ThreadMethodOne extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
