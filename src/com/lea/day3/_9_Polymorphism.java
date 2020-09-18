package com.lea.day3;

/**
 * @author aCheng
 * @create 2020/8/6 18:05
 * 
 * 多态：面向对象中最重要的概念 理解 一个事物的多种形态
 * 对象的多态性：父类的引用指向子类 -》直接应用在抽象类和接口上
 * 多态性是一个运行时行为
 *
 * 2.多态的使用：虚拟方法调用（调用子父类同名同参方法时，实际执行的是子类重写父类的方法），
 *      在编译器只能调用父类中声明的方法，但在运行期时，实际执行的是子类重写父类的方法
 *
 *          java引用变量有两个类型：编译时类型和运行时类型。编译时类型由声明该变量时使用的类型决定，
 *      运行时类型由实际赋值给变量的对象决定。
 *      简称：编译前看左边，编译后看右边
 *
 *      若编译时类型和运行时类型不一致，就出现对象的多态性（Polymorphism）
 *
 *      多态情况下：“看左边”: 看的是父类的引用（父类中不具备子类特有的方法）
 *                “看右边”：看的是子类的对象（实际运行的是子类重写父类的方法）
 *
 *   多态的使用前提 是继承和方法重写
 *
 */
public class _9_Polymorphism {

    public static void main(String[] args) {
        Animal a = new Dog();
        a.name = "dog";
        //  Cannot resolve symbol 'run'，a调用子类特有的方法，不成功， 是声明变量类型是父类，所以编译时，只能Animal中的方法
//    Animal类中不存在 run方法， 这里需要强转类型，转成子类的类型 才能调用
//    a.run();
        if (a instanceof  Dog) {
            Dog d = (Dog) a;
            d.name = a.name;
            d.run();
            // 强转不会复制属性
            System.out.println(d.name);
        };

        Dog d = (Dog) new Animal();
        d.run();
    }


}


class Animal {
    String name;

    public void eat(){
        System.out.println("吃");
    }
}

class Dog extends Animal {
    String name;

    public void eat(){
        System.out.println("wang！wang！wang！");
    }

    public void run(){
        System.out.println("跟着主人跑步");
    }
}
