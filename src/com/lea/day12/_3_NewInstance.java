package com.lea.day12;

import org.junit.Test;

/**
 * @author aCheng
 * @create 2020/09/10 下午 5:16
 */
public class _3_NewInstance {

    @Test
    public void test() throws IllegalAccessException, InstantiationException {
        Class<Person> clazz = Person.class;
        // 创建对应的运行时类的对象。内部调用了运行时类的空参构造器。（如果没有空参构造器，或 空参构造器权限修饰符是私有的，调用此方法报错）
        Person person = clazz.newInstance();
    }
}
