package com.lea.day5;

/**
 * @author aCheng
 * @create 2020/08/17 上午 11:40
 */
public class _5_DeadLock implements Runnable {

    A a = new A();
    B b = new B();

    public void init() {
        Thread.currentThread().setName("主线程");
        a.foo(b);
        System.out.println("进入了主线程之后");
    }

    public void run() {
        Thread.currentThread().setName("副线程");
        b.bar(a);
        System.out.println("进入了副线程之后");
    }

    public static void main(String[] args) {
        _5_DeadLock deadLock = new _5_DeadLock();
        new Thread(deadLock).start();
        deadLock.init();
    }

}

class A {

    public synchronized void foo(B b) {  // 同步锁，同步监视器拿的是A的对象
        System.out.println("当前线程名：" + Thread.currentThread().getName() + "进入了A实例的foo方法");

//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("当前线程名：" + Thread.currentThread().getName() + "企图调用B实例的last方法");

        b.last();
    }

    public synchronized  void last() {
        System.out.println("进入A类的last方法");
    }
}

class B {

    public synchronized void bar(A a) { // 同步监视器：当前对象
        System.out.println("当前线程名：" + Thread.currentThread().getName() + "进入了B实例的bar方法");

//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("当前线程名：" + Thread.currentThread().getName() + "企图调用A实例的last方法");

        a.last();
    }

    public synchronized  void last() {
        System.out.println("进入B类的last方法");
    }
}
