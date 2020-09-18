package com.lea.day13;

/**
 * @author lzc
 * @create 2020/09/16 下午 3:14
 */
public class Boy {

    private String name;

    private Integer age;

    private Girl girl;

    public Boy(Girl girl) {
        this.girl = girl;
    }

    public Boy() { }

    public Boy(String name) {
        this.name = name;
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
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
