package com.lea.day6;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * jdk8之前的日期时间api测试
 * 1.System类中的currentTimeMills();
 * 2.java.util.Date和子类java.sql.Date;
 * 3.SimpleDateFormat
 * 4.Calendar
 * @author aCheng
 * @create 2020/08/21 上午 10:21
 */
public class _3_Date {
    /*
    SimepleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析
    两个操作
    1.格式化： 日期---》字符串
    2.解析：  字符串---》日期
     */

    public static void main(String[] args) {

    }

    @Test
    public void testSimpleDateFormat() throws ParseException {
        // 实例化 默认构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        Date data = new Date();
        System.out.println(data);

        String format = sdf.format(data);
        System.out.println(format);

        // **********
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MMMMM.dd GGG hh:mm aaa");
        String format1 = sdf1.format(data);
        System.out.println(format1);

        // yyyy 和 YYYY 有区别 YYYY表示当天所在的周属于的年份  选择yyyy不会出现日期和当前时间不匹配问题
        // **********
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:sss");
        String format2 = sdf2.format(data);
        System.out.println(format2);
        Date parse = sdf2.parse("2021-1-01 18:00:00");
        System.out.println(sdf2.format(parse));

    }

    @Test
    public void testCalendar() {
        // 实例化
        Calendar calendar = Calendar.getInstance();
//        Calendar calendar1 = new GregorianCalendar();
//        calendar.get()
//        add() 等等方法
    }
}
