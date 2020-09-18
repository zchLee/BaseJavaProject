package com.lea.day3;

/**
 * @author aCheng
 * @create 2020/8/12 10:18
 *
 * 模板方法设计模式 （抽象类的应用）
 *  解决问题
 *      当功能内部一部分实现是确定的，一部分实现是不确定的，这时就可以把不确定的部分暴露出来 给子类实现
 *
 */
public class _13_TeamplateMethod {

    public static void main(String[] args) {
        Teamplate t = new subTeamplate();
        t.spendTime();
    }
}

abstract class Teamplate {

    public void spendTime() {
        long start = System.currentTimeMillis();

        code();  // 不确定的部分，易变的部分

        long end = System.currentTimeMillis();

        System.out.println("花费的时间为：" + (end - start));

    }

    public abstract void code();
}

class subTeamplate extends Teamplate {

    @Override
    public void code() {
        System.out.println("code..");
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
