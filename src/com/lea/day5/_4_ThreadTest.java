package com.lea.day5;

/**
 * @author aCheng
 * @create 2020/08/17 上午 11:22
 *  线程的死锁演示
 *   1.死锁的理解：不同的线程分别占用对方需要的同步资源不放弃，都在等对方放弃自己需要的同步资源
 *   2.出现死锁不会抛出异常，不会出现提示，只是所有线程都处于阻塞状态，无法继续。使用同步时 需要避免死锁
 */
public class _4_ThreadTest {

    public static void main(String[] args) {

        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

        new Thread() {
            @Override
            public void run() {
                synchronized (s1) {
                    s1.append("a");
                    s2.append("1");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (s2) {
                        s1.append("b");
                        s2.append("2");

                        System.out.println(s1.toString());
                        System.out.println(s2.toString());
                    }
                }
            }
        }.start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2) {
                    s1.append("c");
                    s2.append("3");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (s1) {
                        s1.append("d");
                        s2.append("4");

                        System.out.println(s1.toString());
                        System.out.println(s2.toString());
                    }
                }
            }
        }).start();



    }
}
