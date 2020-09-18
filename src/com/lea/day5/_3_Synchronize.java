package com.lea.day5;

/**
 * @author aCheng
 * @create 2020/08/16 下午 10:49
 *
 * 线程安全问题：同步机制
 *      1. 同步代码块
 *          synchronized(同步监视器) {
 *              操作共享数据的代码（需要同步的代码）
 *          }
 *          同步监视器： 俗称锁，任何一个类的对象都可以充当一个锁
 *              要求多个线程必须公用同一把锁
 *      2. 同步方法
 *      public sychronized void method(){
 *          // 操作共享数据的代码
 *      }
 *      1.同步方法同样仍然涉及到同步监视器，只是不需要我们显示声明，
 *      2. 非静态的同步方法，同步监视器是this
 *         对于静态的同步方法，同步讲师器是当前类本身
 */
public class _3_Synchronize {

    public static void main(String[] args) {
        Window window = new Window();

        Thread t1 = new Thread(window);
        Thread t2 = new Thread(window);
        Thread t3 = new Thread(window);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

}

class Window implements Runnable {

    private static volatile int num = 100;

    @Override
    public void run() {
        while (num > 0) {
            if (num > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " : " + num);
                num--;
            }else {
                break;
            }
        }
    }
}
