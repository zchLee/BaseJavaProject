package com.lea.day13;

/**
 * @author lzc
 * @create 2020/09/16 下午 3:13
 */
public class Girl {

    private String name;

    private Integer age;

    public Girl() {}

    public Girl(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
