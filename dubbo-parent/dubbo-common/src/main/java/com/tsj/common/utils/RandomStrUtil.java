package com.tsj.common.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class RandomStrUtil {
	
	/**
	 * @description 采用安全的随机数，随机生成一个长度为length长的字母（大小写）、数字的字符串
	 * @param @param length 表示生成字符串的长度
	 * @param @return   
	 * @return String    返回长度为length长的字母（大小写）、数字的字符串
	 * @throws 
	 * @author 赵以宝
	 * @date 2015年12月10日 上午10:58:01
	 */
	public static String getRandomString(int length) {
		String base = "abcdefghijklmnopqrstuvwxyzQWERTYUIOPASDFGHJKLZXCVBNM0123456789";
		return genSecureRandomString(base,length);
	}
	/**
	 * 
	 * @description 采用安全的随机数，来随机生成一个长度为length长的数字的字符串
	 * @param @param length 表示生成字符串的长度
	 * @param @return   
	 * @return String    返回类型 
	 * @throws 
	 * @author 赵以宝
	 * @date 2015年12月10日 上午11:07:08
	 */
	public static String getRandomDigitString(int length) {
		String base = "0123456789";
		return genSecureRandomString(base,length);
	}

	
	/**
	 * @description 采用安全的随机数，根据传入的字符集随机生成一个长度为length长的字符串
	 * @param length
	 * @return String    返回长度为length长的数字的字符串
	 * @throws 
	 * @author 赵以宝
	 * @date 2015年12月10日 上午10:59:01
	 */
	public static String genSecureRandomString(String base, int length) { // length表示生成字符串的长度
		long seed = System.currentTimeMillis() + 538309;
		SecureRandom secureRandom = null; // 安全随机类
		try {
			secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(seed);
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = secureRandom.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
	 System.out.println(getRandomString(16));
	  
	}
}
