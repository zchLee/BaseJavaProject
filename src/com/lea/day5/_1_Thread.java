package com.lea.day5;

/**
 * @author aCheng
 * @create 2020/8/16 17:23
 * Thread类方法
 *  1.yield(): 释放当前cpu的执行权（释放后有可能 再次被授权执行）
 *  2.join(): 在线程a中调用线程b的join(),此时线程a就进入阻塞状态，知道线程b执行完毕，
 *      线程a才结束阻塞状态
 *  3.stop(): 强制线程生命周期结束。不推荐使用
 *  4. isAlive(): 返回true，表示当前线程还活着，
 *  5. sleep(): 让当前线程睡眠 指定时间， 睡眠时，当前线程时阻塞状态
 *
 *   线程优先级：
        MIN_PRIORITY = 1; 最低级
        NORM_PRIORITY=5;  中级（默认）
        MAX_PRIORITY=10;  最高级
     获取和设置当前线程的优先级：
        getPriority()  获取当前线程有限级
        setPriority(int newPriority)  设置当前线程优先级
    优先级不代表一定优先，有几率会优先执行，高优先级的线程要抢占低优先级的线程cpt的执行权，
但是只是概率上讲，高优先级高概率的情况下，并不意味着 高优先级执行完毕后才执行 低优先级的线程
 */
public class _1_Thread {

    public static void main(String[] args) {
        _1_ThreadMethodOne one = new _1_ThreadMethodOne();
        one.start();

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }

                    try {
                        one.join();  // 挂起当前线程，等待目标线程执行完成
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    if (i % 50 == 0) {
//                        yield(); // 释放当前线程执行权
//                    }
                }
            }
        }.start();
    }
}
