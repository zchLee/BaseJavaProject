package com.lea.day6;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author aCheng
 * @create 2020/08/21 上午 11:09
 */
public class _4_jdk8Date {

    /*
     LocalDate、LocalTime、LocalDateTime的使用
     */
    @Test
    public void testLocalDateTime() {
        // 当前日期
        LocalDate now = LocalDate.now();
        // 当前时间
        LocalTime time = LocalTime.now();
        // 当前日期和时间
        LocalDateTime now1 = LocalDateTime.now();
        System.out.println(now);
        System.out.println(time);
        System.out.println(now1);

        System.out.println("-----------------------------");
        // 直接赋值，没有偏移量
        LocalDateTime of = LocalDateTime.of(2020, 8, 9, 11, 19, 12);
        System.out.println(of);
        // 修改日期的时间  体现了不可变性
        LocalDateTime localDateTime = of.withHour(4);
        System.out.println(localDateTime);

        long l = of.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println(l);
        System.out.println(new Date().getTime());
    }

    /*
    瞬时
     */
    @Test
    public void tsetInstant() {
        // 子午线的时间
        Instant now = Instant.now();
        System.out.println(now);
        // 中国时间是东八区
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
        System.out.println(offsetDateTime.toEpochSecond());

        // ofEpochMilli 给定毫秒数 获取instant实例
        Instant instant = Instant.ofEpochMilli(1597980941L);
        System.out.println(instant);
    }


    @Test
    public void testDateTimeFormatte() {
        // 实例化
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String now = LocalDateTime.now().format(df);
        System.out.println(now);
    }
}
