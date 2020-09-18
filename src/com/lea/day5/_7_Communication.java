package com.lea.day5;

/**
 *
 * 线程通信  使用两个线程交替打印1-100
 *
 *  涉及到三个方法：
 *   wait(): 一旦执行方法，当前线程就进入阻塞状态，并释放同步监视器
 *   notify(): 一旦执行此方法，就会唤醒被wait的一个线程。如果有多个线程被wait，就唤醒优先级搞得线程
 *   notifyAll(): 一旦执行此方法，就会唤醒所有被wait的线程。
 * 说明：
 *   1.以上只能出现在同步代码块中或同步方法中。
 *   2. 以上方法的调用者必须是同步代码块或同步方法中的同步监视器。
 *      否则会出现IllegalMonitorStateException异常
 *
 *  面试题:
 *      sleep()和wait()方法的异同？
 *          1.相同点：一旦执行方法，都可以使得当前的线程进入阻塞状态。
 *          2.不同点：
 *              > 两个方法声明的位置不同；Thread类中声明的sleep(),Object类中声明的wait();
 *              > 调用要求不一样： sleep可以在任意地方调用，wait()必须使用在同步代码块或方法中
 *              > 关于是否释放同步监视器：如果两个方法都是使用在同步代码块或同步方法中，sleep()不会释放锁，wait()会释放锁。
 * @author aCheng
 * @create 2020/08/17 下午 2:11
 */
class Number implements Runnable {

    private int number = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                // 唤醒阻塞的锁
                notifyAll();
                if (number <= 100) {
                    try {
                        // 当前线程不会释放锁，但是会休眠指定时间
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "打印：" + number);
                    number++;
                    try {
                        // 当前线程释放锁，进入阻塞状态
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }
        }
    }
}

public class _7_Communication {

    public static void main(String[] args) {
        Number number = new Number();

        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);
        Thread t3 = new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");
        t3.setName("线程3");

        t1.start();
        t2.start();
        t3.start();


    }
}
