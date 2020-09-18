package com.lea.day5;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全方式三：Lock锁 ---- jdk5.0新增
 * 1. synchronized 和 lock的异同？
 *  同： 二者都是解决线程安全问题的
 *  不同： synchronized机制在执行完相应的代码逻辑以后，自动释放同步监视器
 *          lock需要手动的启动（lock()）和释放锁资源（unlock()）
 *
 * @author aCheng
 * @create 2020/08/17 下午 1:44
 */
class Window2 implements Runnable {

    private int tickter = 100;

    // 实例化重入锁
    private static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                // 调用lock加锁
                lock.lock();
                if (tickter > 0) {
                    System.out.println(Thread.currentThread().getName() + ":售票，票号为" + tickter);
                    tickter--;
                }else {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // 调用unlock释放锁
                lock.unlock();
            }
        }
    }
}
public class _6_Lock {

    public static void main(String[] args) {
        Window2 window = new Window2();
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
