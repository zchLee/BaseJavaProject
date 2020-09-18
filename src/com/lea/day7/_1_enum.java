package com.lea.day7;

/**
 * 1.枚举类的使用
 * 1.枚举类的理解，类的对象只有有限个，确定的，我们称为此类为枚举类
 * 2.当需要定义一组常量时，强烈建议使用枚举类
 * 3.如果枚举类只有一个对象，则可以作为单例模式的实现方式
 * <p>
 *
 * 2.枚举类的定义
 * 方式一：jdk5.0之前，自定义枚举类
 * 方式二：jdk5.0时，使用enum关键字
 *
 * 3.enum可以实现接口
 *      情况一、实现接口，在enum中实现抽象方法
 *      情况二、让枚举类对象分别实现接口中的方法
 *
 * @author aCheng
 * @create 2020/08/21 下午 2:56
 */
public class _1_enum {

    public static void main(String[] args) {
        Season1.AUTUMN.show();
    }

}

// jdk5.0 新特性 enum
/*
 定义的枚举类默认继承于java.lang.Enum类
 */
enum Season1 implements Info {
    //   1.提供当前枚举类的多个对象，多个对象之间用逗号隔开, 末尾用分号结尾
    SPRING("春天", "万物复苏") {
        // 实现接口第二种重写方式
        @Override
        public void show() {
            System.out.println("冬天");
        }
    },
    SUMMER("夏天", "夏日炎炎") {
        // 实现接口第二种重写方式
        @Override
        public void show() {
            System.out.println("夏天");
        }
    },
    AUTUMN("秋天", "秋高气爽") {
        // 实现接口第二种重写方式
        @Override
        public void show() {
            System.out.println("秋天");
        }
    },
    WINTER("冬天", "冬日寂静") {
        // 实现接口第二种重写方式
        @Override
        public void show() {
            System.out.println("冬天");
        }
    };

    // 2.声明Season对象的属性
    private final String seasonName;
    private final String seasonDsc;

    // 3. 私有化类的构造器
    private Season1(String seasonName, String seasonDsc) {
        // 3.1 给私有属性赋值
        this.seasonName = seasonName;
        this.seasonDsc = seasonDsc;
    }

    // 4.获取枚举类的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDsc() {
        return seasonDsc;
    }

    // ... 其他诉求

    // 实现接口第一种方式, 重写
//    @Override
//    public void show() {
//        System.out.println("重写balbal");
//    }
}

// 接口
interface Info {
    void show();
}

// 自定义枚举
class Season {
    // 1.声明Season对象的属性
    private final String seasonName;
    private final String seasonDsc;

    // 2. 私有化类的构造器
    private Season(String seasonName, String seasonDsc) {
        // 2.1 给私有属性赋值
        this.seasonName = seasonName;
        this.seasonDsc = seasonDsc;
    }

    //   3.提供当前枚举类的多个对象
    public static final Season SPRING = new Season("春天", "万物复苏");
    public static final Season SUMMER = new Season("夏天", "夏日炎炎");
    public static final Season AUTUMN = new Season("秋天", "秋高气爽");
    public static final Season WINTER = new Season("冬天", "冬日寂静");

    // 4.获取枚举类的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDsc() {
        return seasonDsc;
    }
    // ... 其他诉求
}
