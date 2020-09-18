package com.lea.day5;

/**
 * @author aCheng
 * @create 2020/08/16 下午 9:48
 *
 *  线程的生命周期：
 *      1. 新建  new Thread();
 *      2. 就绪  调用线程start() 等待cpu调度;
 *      3. 运行  获取到cpu的执行权才会开始运行
 *              调用yield() 失去执行权，重回就绪状态
 *              线程执行完、调用stop()、出现Error/exception,且未处理 线程变成死亡状态
 *              sleep()、join()、 等待同步锁、wait()、suspend() 线程变成阻塞状态
 *      4. 阻塞  线程闲置，等待重回就绪状态
 *              sleep()时间到了，jion() 目标线程结束、获取同步锁、
 *              notify()\notifyAll()被唤醒、resume();
 *              以上方法执行 结束阻塞状态重回阻塞状态
 *      5. 死亡
 */
public class _2_ThreadState {

    public static void main(String[] args) {
        ThreadRunable r = new ThreadRunable();
        Thread t1 = new Thread(r);
//        Thread t2 = new Thread(r);
        System.out.println(t1.getState());
        t1.start();
        System.out.println(t1.getState());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t1.getState());

    }

}

class ThreadRunable implements Runnable {

    @Override
    public void run() {
//        try {
//            Thread.sleep(5000);  // 线程进入阻塞状态
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("thread is working");
    }
}
