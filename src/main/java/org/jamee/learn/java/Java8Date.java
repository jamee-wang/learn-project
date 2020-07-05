package org.jamee.learn.java;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Java8Date {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("today: " + today);

        LocalTime time = LocalTime.now();
        System.out.println("time: " + time);

        LocalDateTime now = LocalDateTime.now();
        System.out.println("now: " + now);

        System.out.println(String.format("Year: %d, Month: %d, Day: %d, Hour: %d",
                today.getYear(), today.getMonthValue(), now.getDayOfMonth(), time.getHour()));

        LocalDate date = LocalDate.of(2019, 1, 15);
        System.out.println("date: " + date);

        LocalDate yesterday = today.minusDays(1);
        System.out.println("yesterday: " + yesterday);
        LocalDate tomorrow = today.plusDays(1);
        System.out.println("tomorrow: " + tomorrow);

        Period period = Period.between(yesterday, tomorrow);
        System.out.println("period: " + period.getDays());

        System.out.println("isLeapYear: " + today.isLeapYear());

        System.out.println("today.isBefore(tomorrow): " + today.isBefore(tomorrow));

        Clock clock = Clock.systemUTC();
        System.out.println("timestamp: " + clock.millis());

        ZoneId shanghaiTimeZone = ZoneId.of("Asia/Shanghai");
        ZonedDateTime shanghaiTime = ZonedDateTime.of(now, shanghaiTimeZone);
        System.out.println("shanghaiTime: " + shanghaiTime);
        ZonedDateTime newYorkTime = shanghaiTime.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("newYorkTime: " + newYorkTime);

        String dateStr = "2020-08-22 19:23:47";
        LocalDateTime parsedDate = LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("parsedDate: " + parsedDate);
        String formattedDate = parsedDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        System.out.println("formattedDate: " + formattedDate);

        String utcDateStr = "2020-08-22 19:23:47";
        ZonedDateTime utcParsedDate = ZonedDateTime.parse(utcDateStr,
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("UTC")));
        ZonedDateTime parsedShanghaiTime = utcParsedDate.withZoneSameInstant(ZoneId.of("Asia/Shanghai"));
        System.out.println("utcParsedDate: " + utcParsedDate);
        System.out.println("shanghaiTime: " + parsedShanghaiTime);
    }
}
