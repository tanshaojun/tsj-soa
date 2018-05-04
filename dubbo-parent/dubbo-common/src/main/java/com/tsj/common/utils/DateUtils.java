package com.tsj.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	/**
	 * @description 计算时长
	 * @param beginTime 开始时间
	 * @param endTime 结束时间
	 * @return String    返回类型 
	 * @author hxt
	 * @date 2016年12月20日 上午9:10:35
	 */
	public static String getTimeStr(Date beginTime,Date endTime) {
		/**
		 * 秒
		 */
		double timeSecend = Math.ceil(Double.parseDouble(String.valueOf((beginTime.getTime() - endTime.getTime())/1000)));
		String timeStr = "";
		if(timeSecend < 60){
			timeStr = ((int)Math.ceil(timeSecend)) + "秒前";
			
		}else if(timeSecend < 60*60 ){
			timeStr = ((int)Math.ceil(timeSecend/60)) + "分钟前";
			
		}else if(timeSecend < 60 * 60 * 24 ){
			timeStr = ((int)Math.ceil(timeSecend/60/60)) + "小时前";
			
		}else if(timeSecend  < 60 * 60 * 24 * 7 ){
			timeStr = ((int)Math.ceil(timeSecend/60/60/24)) + "天前";
			
		}else if(timeSecend < 60 * 60 * 24 * 7 * 4){
			timeStr = ((int)Math.ceil(timeSecend/60/60/24/7)) + "周前";
			
		}else if(timeSecend < 60 * 60 * 24 * 365){
			timeStr = ((int)Math.ceil(timeSecend/60/60/24/30)) + "月前";
			
		}else {
			timeStr = ((int)Math.ceil(timeSecend/60/60/24/365)) + "年前";
		}
		return timeStr;
	}
	
	/**
	 * 将字符串转成格式的日期
	 * @author 秦贵飞
	 * @date 2015-11-23
	 * @param strDate 需要转换的字符串
	 * @param format  转换格式，如：yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static Date formatStrToDate(String strDate, String format) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {

		}
		return date;
	}
	
	/**
	 * 将日期转成字符串
	 * @author 秦贵飞
	 * @date 2015-11-23
	 * @param date  需要转换的日期
	 * @param format   转换格式，如：yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String formatDateToStr(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	/**
	 * @description 获当前日期的的前一个月
	 * @return Date    返回类型 
	 * @author 秦贵飞
	 * @date 2016年1月11日 下午4:11:51
	 */
	public static Date getLastMonthDate() {
		Calendar lastMonthDate = Calendar.getInstance();
		lastMonthDate.add(Calendar.MONTH, -1);
		return lastMonthDate.getTime();
	}

	/**
	 * @description 获取某一日期的前一天
	 * @param date
	 * @return Date    返回类型 
	 * @author 秦贵飞
	 * @date 2016年1月11日 下午4:14:25
	 */
	public static Date getBeforeDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		date = calendar.getTime();
		return date;
	}
	
	/**
	 * @description 将某一日期增加若干月
	 * @param curr
	 * @param months 增加的月份数，若为负数，则表示往前几个月
	 * @return Date    返回类型 
	 * @author 秦贵飞
	 * @date 2016年1月11日 下午3:44:57
	 */
	public static Date addMonths(Date curr, int months) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(curr);
		calendar.add(Calendar.MONTH, months);
		return calendar.getTime();
	}

	/**
	 * @description 将某一日期增加若干天
	 * @param curr
	 * @param days
	 * @return Date    返回类型 
	 * @author 秦贵飞
	 * @date 2016年1月11日 下午3:43:03
	 */
	public static Date addDays(Date curr, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(curr);
		calendar.add(Calendar.DAY_OF_MONTH, days);
		return calendar.getTime();
	}
	
	/**
	 * @description 将某一日期增加若干小时
	 * @param datetime
	 * @param hours
	 * @return Date    返回类型 
	 * @author 秦贵飞
	 * @date 2016年1月11日 下午3:55:13
	 */
	public static Date addHours(Date date, int hours) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR, hours);
		return calendar.getTime();
	}
	
	
	/**
	 * @description 将某一日期增加若干分钟
	 * @param curr
	 * @param minutes
	 * @return Date    返回类型 
	 * @author 秦贵飞
	 * @date 2016年1月11日 下午3:43:21
	 */
	public static Date addMinutes(Date curr, int minutes) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(curr);
		calendar.add(Calendar.MINUTE, minutes);
		return calendar.getTime();
	}
	
	/**
	 * 获取当前时间加上传入的秒数
	 * 
	 * @author 秦贵飞
	 * @since 2015-11-05
	 * @param minutes
	 * @return
	 */
	public static Date getAddSeconds(int seconds) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.SECOND, +seconds);
		Date delayTime = calendar.getTime();
		return delayTime;
	}
	/**
	 * 
	 * @description 将某一日期增加若干周
	 * @param curr
	 * @param weeks
	 * @return   
	 * @return Date    返回类型 
	 * @throws 
	 * @author 张欢
	 * @date 2017年8月21日 下午7:36:12
	 */
	public static Date addWeeks(Date curr, int weeks) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(curr);
		calendar.add(Calendar.WEDNESDAY, weeks);
		return calendar.getTime();
	}
	/**
	 * 
	 * @description 将某一日期增加若干年
	 * @param curr
	 * @param weeks
	 * @return   
	 * @return Date    返回类型 
	 * @throws 
	 * @author 张欢
	 * @date 2017年8月21日 下午7:36:12
	 */
	public static Date addYears(Date curr, int years) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(curr);
		calendar.add(Calendar.YEAR, years);
		return calendar.getTime();
	}

	/**
	 * 取两个Date之间的天数差<br>
	 * <br>
	 * 例：newerDate是6月3日，olderDate是5月31日，则应返回3 <br>
	 * 一个更极端的列子：newerDate是6月3日 00:01，olderDate是6月2日
	 * 23:59，则应返回1，说明相差一天，即便实际上只差2分钟 <br>
	 * 此代码来自网上 <br>
	 * http://blog.csdn.net/rmartin/article/details/1452867
	 * 
	 * @param newerDate
	 * @param olderDate
	 * @return
	 */
	public static int daysBetween(Date newerDate, Date olderDate) {
		Calendar cNow = Calendar.getInstance();
		Calendar cReturnDate = Calendar.getInstance();
		cNow.setTime(newerDate);
		cReturnDate.setTime(olderDate);
		setTimeToMidnight(cNow);
		setTimeToMidnight(cReturnDate);
		long todayMs = cNow.getTimeInMillis();
		// zyb 2015/4/8 将日期中毫秒归零，以避免错误
		todayMs = (todayMs / 1000L) * 1000L;
		long returnMs = cReturnDate.getTimeInMillis();
		// zyb 2015/4/8 将日期中毫秒归零，以避免错误
		returnMs = (returnMs / 1000L) * 1000L;
		long intervalMs = todayMs - returnMs;
		return millisecondsToDays(intervalMs);
	}

	/**
	 * 算出两个日期之间相差的分钟数
	 * 
	 * @param newerDate
	 * @param olderDate
	 * @return
	 */
	public static int MinutesBetween(Date newerDate, Date olderDate) {
		Calendar cNow = Calendar.getInstance();
		Calendar cReturnDate = Calendar.getInstance();
		cNow.setTime(newerDate);
		cReturnDate.setTime(olderDate);
		long todayMs = cNow.getTimeInMillis();
		long returnMs = cReturnDate.getTimeInMillis();
		long intervalMs = todayMs - returnMs;
		intervalMs = intervalMs / (1000 * 60);
		return (int) intervalMs;
	}

	private static int millisecondsToDays(long intervalMs) {
		return (int) (intervalMs / (1000 * 86400));
	}
	
	/**
	 * @description 设置时间为0点
	 */
	public static Date setTimeToMidnight(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	/**
	 * @description 设置时间为0点
	 */
	public static Date setTimeToMidnight(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	/**
	 * @description 设置某一日期的时间
	 * @param date
	 * @param hour
	 * @return Date    返回类型 
	 * @author 秦贵飞
	 * @date 2016年2月22日 下午3:58:48
	 */
	public static Date setHours(Date date, int hour) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}


	/**
	 * 返回 计算每个月的天数
	 * @param year  XXXX年
	 * @param month  XX月
	 * @return
	 */
	public static int getDaysOfMonth2(int year, int month) {
		int days = 0;
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 9
				|| month == 10 || month == 12) {
			days = 31;
		} else if (month == 4 || month == 6 || month == 8 || month == 11) {
			days = 30;
		} else { // 2月份，闰年29天、平年28天
			if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
				days = 29;
			} else {
				days = 28;
			}
		}
		return days;
	}
	/**
	 * 获取时间差，秒数
	 */
	public static long getSecond(Date beginTime,Date endTime)throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String statrsTime= sdf.format(beginTime).toString();
	    String orveTime  =  sdf.format(endTime).toString();
	   // 将截取到的时间字符串转化为时间格式的字符串 **/
	    Date begin=sdf.parse(statrsTime);
	    Date end = sdf.parse(orveTime);
	    long Second=(end.getTime()-begin.getTime())/1000;//除以1000是为了转换成秒
	    return Second;
	}
	
	/**
	 * 比较时间大小
	 */
	public static Boolean compareToDate(Date registerDate,Date nextDayDate){
		Calendar c1= Calendar.getInstance();
		Calendar c2= Calendar.getInstance();
	    boolean isflag=false;
			try {
				c1.setTime(registerDate);
				c2.setTime(nextDayDate);
			} catch (Exception e) {
				e.printStackTrace();
			}
			int result=c1.compareTo(c2);
			if(result<0){
	            isflag=false;
			}else{
				isflag=true;	
			}
		return isflag;
	}
	

	/**
	 * 将时间转成"yyyy-MM-dd"格式的字符串
	 * @param date  时间
	 * @return
	 */
	public static String formatToYYYYMMDD(Date date) {
		if (date != null) {
			return YZYDateFormat.getInstance("yyyy-MM-dd").format(date);
		} else {
			return "null";
		}

	}
	public static void main(String[] args) {
		System.out.println(intoYYYYMMDD(new Date()));
		System.out.println(compareToDate(new Date(),addDays(new Date(),-4)));

	}

	/**
	 * 将时间转成"yyyy-MM-dd"格式的字符串
	 * 
	 * @param date
	 *            zhenglp
	 * @return
	 * 
	 */
	public static String intoYYYYMMDD(Date date) {
		if (date != null) {
			return YZYDateFormat.getInstance("yyyyMMdd").format(date);
		} else {
			return "null";
		}

	}

	public static String formatToYYYYMMDDMMHHSS(Date date) {
		YZYDateFormat format = YZYDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}

	public static Date formatToDayByYYYYMMDDHHMMSS(String s)
			throws ParseException {
		YZYDateFormat format = YZYDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");
		return format.parse(s);
	}

	public static Date formatToDayByYYYYMMDDMMHH(String s)
			throws ParseException {
		YZYDateFormat format = YZYDateFormat.getInstance("yyyy-MM-dd HH:mm");
		return format.parse(s);
	}

	public static String formatToYYYYMMDDMMHHSSSlash(Date date) {
		YZYDateFormat format = YZYDateFormat.getInstance("yyyy/MM/dd HH:mm:ss");
		return format.format(date);
	}

	public static String formatToYYYYMMDDSlash(Date date) {
		YZYDateFormat format = YZYDateFormat.getInstance("yyyy/MM/dd");
		return format.format(date);
	}

	public static String formatToYMZSlash(Date date) {
		YZYDateFormat format = YZYDateFormat.getInstance("yyyy年MM月dd日");
		return format.format(date);
	}

	public static Date formatToDayByYYYYMMDDMMHHSS(String s)
			throws ParseException {
		YZYDateFormat format = YZYDateFormat.getInstance("yyyyMMdd");
		return format.parse(s);
	}
	public static String formatToYMZSlashDel(Date date) {
		YZYDateFormat format = YZYDateFormat.getInstance("yyyy.MM.dd");
		return format.format(date);
	}
	public static String formatToYYYYMMDDHHMMSS(Date date) {
		YZYDateFormat format = YZYDateFormat.getInstance("yyyyMMddHHmmss");
		return format.format(date);
	}
	
	/**
	 * 将传入的参数封装成枚举进行return
	 * @author 刘松
	 * @param errorCode
	 * @param errorMessage
	 * @param innMessage
	 * @return
	 */

	
	/**
	 * 获取当年的最后一天  返回的日期格式 yyyy-MM-dd
	 * @author 王刘闯
	 * @return
	 */
	public static String getYearLast(){
		 Calendar currCal=Calendar.getInstance();
		 int year =currCal.get(Calendar.YEAR);
		 currCal.clear();
		 currCal.set(Calendar.YEAR,year);
		 currCal.roll(Calendar.DAY_OF_YEAR, -1);
		 SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		 return sm.format(currCal.getTime());
	}
	
	/**
	 * 
	 * @description 用当前时间加密，截取20位
	 * @return   
	 * @return String    返回类型 
	 * @throws 
	 * @author 谭少军
	 * @date 2017年6月26日 下午8:56:34
	 */
	public static String getDateMd5(){
		return  MD5Utils.EncoderByMd5(String.valueOf(new Date())).substring(2, 22);
	}
	/**
	 *
	 * @description 描述
	 * @param timestamp 时间戳long值
	 * @param format  要转换的格式
	 * @return    返回类型
	 * @author 段华微
	 * @date 2018-01-25 15:25:49
	 */
	public static String timeStamp2FormatDateStr(String timestamp, String format) {
		if (org.apache.commons.lang3.StringUtils.isBlank(timestamp)) {
			return "";
		}
		if (org.apache.commons.lang3.StringUtils.isBlank(format)) {
			format = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date(Long.valueOf(timestamp)));
	}
	
}
