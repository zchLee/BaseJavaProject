package com.lea.day3;

import java.util.Objects;
import java.util.Vector;

/**
 * @author aCheng
 * @create 2020/8/11 13:56
 */
public class _10_Object {

    public static void main(String[] args) {
        TestEquals test = new TestEquals();
        TestEquals test1 = new TestEquals();
        new Integer("3121d");
        new String("abv");
        char zhong = 20013;
        char zhong2 = 20014;
        System.out.println(zhong + "" + zhong2);
        System.out.println(test.equals(test1));

        Vector<Integer> vector = new Vector<>();
        vector.add(1213);
    }
}


class TestEquals{


    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestEquals test = (TestEquals) o;
        return Objects.equals(name, test.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}