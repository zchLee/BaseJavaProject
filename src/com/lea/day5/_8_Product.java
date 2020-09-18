package com.lea.day5;

/**
 *  生产消费者问题
 *   店员一次生成20 超过等待，消费者消费，物品消费完了 就等待
 * @author aCheng
 * @create 2020/08/17 下午 2:39
 */
class Clerk {

    private int product = 0;

    public synchronized void produceProduct() {
        while (true) {
            if (product < 20) {
                product++;
                System.out.println("开始生产第" + product + "个产品");
                notify();
            }else {
                // 等待 用户消费
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 消费产品
    public synchronized void consumptionProduct() {
        while (true) {
            if (product > 0) {
                System.out.println("开始消费第" + product + "个产品");
                product--;
                notify();
            }else {
                // 等待 店员生产
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
// 生产者
class Producer extends Thread {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clerk.produceProduct();
    }
}
// 消费者
class Consumer extends Thread {
    private Clerk clerk;

    public Consumer (Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clerk.consumptionProduct();
    }
}
public class _8_Product {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer p1 = new Producer(clerk);
        Consumer c1 = new Consumer(clerk);

        p1.setName("生产者1");
        c1.setName("消费者1");
        p1.start();
        c1.start();
    }
}
