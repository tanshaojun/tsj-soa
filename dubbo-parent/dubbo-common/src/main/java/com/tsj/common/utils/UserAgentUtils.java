package com.tsj.common.utils;

import com.wallet.common.consts.BrowerTypeEnum;
import com.wallet.common.consts.OsTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 
 * @description 客户端浏览器类型、操作系统类型判断
 * @ClassName: UserAgentUtils
 * @version V1.0
 * @author 赵以宝
 * @Date 2016年7月15日 上午9:10:51
 * Copyright(c) 2015 www.wallet.com  All rights reserved
 *
 */
public class UserAgentUtils{
	
	private static Logger logger = LoggerFactory.getLogger(UserAgentUtils.class);
	
	/**
	 * 
	 * @description 根据useragent返回客户端浏览器类型
	 * @param userAgent
	 * @return   
	 * @return BrowerTypeEnum    返回类型 
	 * @throws 
	 * @author 赵以宝
	 * @date 2016年7月15日 上午9:34:31
	 */
	public static BrowerTypeEnum GetBrowserType(String userAgent) {

		logger.debug("浏览器类型判断 start："+userAgent);
		if (regex("MSIE 9.0", userAgent)) {
            return BrowerTypeEnum.IE9;
        }
		if (regex("MSIE 8.0", userAgent)) {
            return BrowerTypeEnum.IE8;
        }
		if (regex("MSIE 7.0", userAgent)) {
            return BrowerTypeEnum.IE7;
        }
		if (regex("MSIE 6.0", userAgent)) {
            return BrowerTypeEnum.IE6;
        }
		if (regex("Maxthon", userAgent)) {
            return BrowerTypeEnum.MAXTHON;
        }
		if (regex("QQBrowser", userAgent)) {
            return BrowerTypeEnum.QQ;
        }
		if (regex("GreenBrowser", userAgent)) {
            return BrowerTypeEnum.GREEN;
        }
		if (regex("360SE", userAgent)) {
            return BrowerTypeEnum.B360;
        }
		if (regex("Firefox", userAgent)) {
            return BrowerTypeEnum.FIREFOX;
        }
		if (regex("Opera", userAgent)) {
            return BrowerTypeEnum.OPERA;
        }
		if (regex("Chrome", userAgent)) {
            return BrowerTypeEnum.CHROME;
        }
		if (regex("Safari", userAgent)) {
            return BrowerTypeEnum.SAFARI;
        }
		if(regex("SE 2.X",userAgent)) {
            return BrowerTypeEnum.SOGOU;
        }
		if(regex("MicroMessenger",userAgent)) {
            return BrowerTypeEnum.SOGOU;
        }
		if(regex("wallet",userAgent)) {
            return BrowerTypeEnum.WALLET;
        }
		return BrowerTypeEnum.OTHER;
	}



	/**
	 * 
	 * @description 根据useragent返回客户端操作系统类型
	 * @param userAgent
	 * @return   
	 * @return OsTypeEnum    返回类型 
	 * @throws 
	 * @author 赵以宝
	 * @date 2016年7月15日 上午9:41:24
	 */
	public static OsTypeEnum GetOSType(String userAgent) {
		
		logger.debug("操作系统类型判断 start："+userAgent);
		if (userAgent.contains("NT 6.2")) {
            return OsTypeEnum.WIN8;  // Windows 8/Windows Server 2012
        }
		if (userAgent.contains("NT 6.2")) {
            return OsTypeEnum.WIN8;  // Windows 8/Windows Server 2012
        }
		if (userAgent.contains("NT 6.1")) {
            return OsTypeEnum.WIN7;  // Windows 7/Windows Server 2008 R2
        }
		if (userAgent.contains("NT 6.0")) {
            return OsTypeEnum.WIN2008; // Windows Vista/Server 2008
        }
		if (userAgent.contains("NT 5.2")) {
            return OsTypeEnum.WIN2003; // Windows Server 2003
        }
		if (userAgent.contains("NT 5.1")) {
            return OsTypeEnum.WINXP; // Windows XP
        }
		if (userAgent.contains("NT 5")) {
            return OsTypeEnum.WIN2K; // Windows 2000
        }
		if (userAgent.contains("NT 4")) {
            return OsTypeEnum.WINNT4; // Windows NT4
        }
		if (userAgent.contains("Me")) {
            return OsTypeEnum.WINME; // Windows Me
        }
		if (userAgent.contains("98")) {
            return OsTypeEnum.WIN98; // Windows 98
        }
		if (userAgent.contains("95")) {
            return OsTypeEnum.WIN95; // Windows 95
        }
		if (userAgent.contains("Mac")) {
            return OsTypeEnum.MAC; // Mac
        }
		if (userAgent.contains("Unix")) {
            return OsTypeEnum.UNIX; // UNIX
        }
		if (userAgent.contains("Linux")) {
            return OsTypeEnum.LINUX; // Linux
        }
		if (userAgent.contains("SunOS")) {
            return OsTypeEnum.SUNOS; //SunOS
        }
		if (userAgent.contains("iOS")) {
            return OsTypeEnum.IOS; //SunOS
        }
		return OsTypeEnum.OTHER;
	}
	
	/**
	 * 
	 * @description 判断是否是PC端浏览器，不是很严谨，可能有漏判
	 * @param userAgent
	 * @return   
	 * @return boolean    返回类型 
	 * @throws 
	 * @author 赵以宝
	 * @date 2016年8月1日 下午5:06:53
	 */
	public static boolean isWebBrowser(String userAgent) {
		if (userAgent.contains("Windows NT")|| userAgent.contains("Macintosh")) {
            return true;
        }
		return false;
	}
	/**
	 * 根据正则表达式匹配字符串
	 * @param regex 正则表达式字符串
	 * @param str 浏览器字符形参
	 * @return 返回浏览器判断boolean值结果
	 */
	public static boolean regex(String regex, String str) {
		Pattern p = Pattern.compile(regex, Pattern.MULTILINE);
		Matcher m = p.matcher(str);
		return m.find();
	}
}