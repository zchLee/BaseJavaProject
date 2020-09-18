package com.lea.day9;

import org.junit.Test;

import java.util.HashMap;

/**
 * jdk1.5时引入
 * 所谓泛型，就是允许在定义类、接口时通过一个标识表示类中某个属性的类型
 * 或方法的返回值及参数类型。
 * 这个类型参数将在使用时(继承或实现这个接口，用这个类型声明变量、创建对象时)确定（即传入实际的类型参数，也称为类型实参）
 * 总结：
 *  实例化时不指名类型的泛型，就不会有编译前的类型检查（即可以添加任何数据），
 *  此时，类型默认为java.lang.Object类型。
 *  有可能会使在遍历时出现类型转换错误。
 *
 *  多个泛型需要用英文逗号隔开
 *
 * 注意点：
 *      泛型类型必须是类，不能是基本数据类型。需要用到基本数据类型时，用包装类型
 *
 *      静态方法里不可用泛型。静态方法归类所有，而泛型是构造类对象时被确认
 *      public static void method(T t){
 *          sout(t);
 *      }
 *
 *      异常类不能声明为泛型类
 *      public void method(){
 *      // 编译不通过
 *            try{
 *
 *            }catch(T t) {
 *              // T 有可能不是异常类
 *            }
 *      }
 *
 *      新建泛型数组
 *      T[] ts = new T[]; // 编译不通过
 *      T[] tss = (T[])new Object{10}
 *
 * @author aCheng
 * @create 2020/09/01 下午 10:55
 */
public class _1_Generic {

    // 自定义类泛型
    @Test
    public void test() {
        // 定义了泛型类，实例化没有指明类的泛型，则认为此泛型类为Object类型
        // 要求： 如果大家定义了类是带泛型的，建议在实例化时要指明类的泛型
        _2_MyGeneric<Order> myGeneric = new _2_MyGeneric<Order>();
        myGeneric.age = 13;
        myGeneric.name = "tom";
        myGeneric.t = new Order("132", 9.0, "god");
        System.out.println(myGeneric);
    }

    public static void main(String[] args) {
        HashMap<String, Integer> data = new HashMap<String,Integer>();
        // 右边省略泛型具体类型 ---》 jdk7新特性，类型推断
        HashMap<String, Integer> jdk7 = new HashMap<>();

    }


}