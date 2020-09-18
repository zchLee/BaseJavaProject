package com.lea.day12;

import java.util.Objects;

/**
 * @author aCheng
 * @create 2020/09/10 下午 5:46
 */
@MyAnnotation(value = "hi")
public class Persons extends Creature<Persons> implements Comparable<Persons>, MyInterface {

    private String name;
    int age;
    public int id;

    public Persons() {}

    @MyAnnotation(value = "cons")
    private Persons(String name) {
        this.name = name;
    }

    public Persons(int age) {
        this.age = age;
    }

    public Persons(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @MyAnnotation
    private String show(String nation) {
        System.out.println("我的国籍是" + nation);
        return nation;
    }

    public String showName() {

        return name;
    }

    public static void showDesc() {
        System.out.println("调用静态方法");
    }

    @MyAnnotation
    public String display(String insterets) {
        return insterets;
    }

    @Override
    public void info() {
        System.out.println("i'm a person!");
    }

    @Override
    public String toString() {
        return "Persons{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persons persons = (Persons) o;
        return age == persons.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }

    @Override
    public int compareTo(Persons o) {
        return this.getAge() - o.getAge();
    }
}
