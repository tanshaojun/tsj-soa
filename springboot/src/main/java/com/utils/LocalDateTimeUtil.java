package com.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.Objects;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2019/5/21 16:02
 */
public class LocalDateTimeUtil {

    private static final String DEFAULT_FORMAT_STRING = "yyyy-MM-dd HH:mm:ss";


    /**
     * Date转换为LocalDate
     *
     * @param date
     * @return
     */
    public static LocalDate UDateToLocalDate(Date date) {
        Objects.requireNonNull(date, "data");
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime.toLocalDate();
    }

    /**
     * LocalDate转换为Date
     *
     * @param localDate
     * @return
     */
    public static Date LocalDateToUdate(LocalDate localDate) {
        Objects.requireNonNull(localDate, "localDate");
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }


    /**
     * Date转换为LocalDateTime
     *
     * @param date
     * @return
     */
    public static LocalDateTime convertDateToLDT(Date date) {
        Objects.requireNonNull(date, "date");
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * LocalDateTime转换为Date
     *
     * @param localDateTime
     * @return
     */
    public static Date convertLDTToDate(LocalDateTime localDateTime) {
        Objects.requireNonNull(localDateTime, "localDateTime");
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }


    /**
     * 获取指定日期的毫秒
     *
     * @param localDateTime
     * @return
     */
    public static Long getMilliByTime(LocalDateTime localDateTime) {
        Objects.requireNonNull(localDateTime, "localDateTime");
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 获取指定日期的秒
     *
     * @param localDateTime
     * @return
     */
    public static Long getSecondsByTime(LocalDateTime localDateTime) {
        Objects.requireNonNull(localDateTime, "localDateTime");
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    /**
     * 获取指定时间的指定格式
     * 默认为：yyyy-MM-dd HH:mm:ss
     *
     * @param localDateTime
     * @param pattern
     * @return
     */
    public static String formatTime(LocalDateTime localDateTime, String pattern) {
        Objects.requireNonNull(localDateTime, "localDateTime");
        if ("".equals(pattern) || null == pattern) pattern = DEFAULT_FORMAT_STRING;
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 获取当前时间的指定格式
     * 默认为：yyyy-MM-dd HH:mm:ss
     *
     * @param pattern
     * @return
     */
    public static String formatNow(String pattern) {
        if ("".equals(pattern) || null == pattern) pattern = DEFAULT_FORMAT_STRING;
        return formatTime(LocalDateTime.now(), pattern);
    }

    /**
     * 获取当前时间的指定格式
     * 默认为：yyyy-MM-dd HH:mm:ss
     *
     * @param pattern
     * @return
     */
    public static String formatTime(Date date, String pattern) {
        Objects.requireNonNull(date, "date");
        if ("".equals(pattern) || null == pattern) pattern = DEFAULT_FORMAT_STRING;
        return formatTime(convertDateToLDT(date), pattern);
    }


    /**
     * 日期加上一个数,根据field不同加不同值,field为ChronoUnit.*
     *
     * @param localDateTime
     * @param number
     * @param field
     * @return
     */
    public static Date plusToDate(LocalDateTime localDateTime, long number, TemporalUnit field) {
        Objects.requireNonNull(localDateTime, "localDateTime");
        return convertLDTToDate(plus(localDateTime, number, field));
    }


    private static LocalDateTime plus(LocalDateTime time, long number, TemporalUnit field) {
        return time.plus(number, field);
    }

    /**
     * 日期减少上一个数,根据field不同加不同值,field为ChronoUnit.*
     *
     * @param localDateTime
     * @param number
     * @param field
     * @return
     */
    public static Date minuToDate(LocalDateTime localDateTime, long number, TemporalUnit field) {
        Objects.requireNonNull(localDateTime, "localDateTime");
        return convertLDTToDate(minu(localDateTime, number, field));
    }


    private static LocalDateTime minu(LocalDateTime time, long number, TemporalUnit field) {
        return time.minus(number, field);
    }

    /**
     * 获取两个日期的差  field参数为ChronoUnit.*
     *
     * @param startTime
     * @param endTime
     * @param field     单位(年月日时分秒)
     * @return
     */
    public static long betweenTwoTime(LocalDateTime startTime, LocalDateTime endTime, ChronoUnit field) {
        Objects.requireNonNull(startTime, "startTime");
        Objects.requireNonNull(endTime, "endTime");
        Period period = Period.between(LocalDate.from(startTime), LocalDate.from(endTime));
        if (field == ChronoUnit.YEARS) return period.getYears();
        if (field == ChronoUnit.MONTHS) return period.getYears() * 12 + period.getMonths();
        return field.between(startTime, endTime);
    }
}
