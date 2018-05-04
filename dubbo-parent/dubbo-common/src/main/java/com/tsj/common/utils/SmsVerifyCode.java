/**
 * 2012.9.13

 * author liwenjuan
 * 生成一个六位数随机验证码
 */
package com.tsj.common.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * @description 短信和邮件验证码生成和管理类
 * @ClassName: SmsVerifyCode
 * @version V1.0
 * @author 赵以宝
 * @Date 2015年12月9日 下午2:19:01
 * Copyright(c) 2015 www.ehean.com  All rights reserved
 *
 */
public class SmsVerifyCode {
	private static Logger logger = LoggerFactory.getLogger(SmsVerifyCode.class);
	private final static int OFFSET = 538309;
	public final static int EXPIRED = 30 * 60 * 3000; // 失效时间（30分钟）
	public final static int FREQ = 1 * 60 * 1000; // 同一用途重复发送频率（1分钟）
	public final static int MAX_ATTEMPTS = 10; // 安全性增强：最大尝试次数

	private long validThru; // 有效期
	private String phoneVCode; // 短信验证码
	private String referrer; // 引用页面
	private String destMobileNum; // 目标接收手机号
	private int hasAttempt; // 已尝试验证次数
	private long lastSent; // 最近发送时间


	/**
	 * @description 构造函数 
	 * @param referrer
	 * @param destMobileNum
	 * @author 赵以宝
	 * @date 2015年12月9日 下午2:20:48
	 */
	public SmsVerifyCode(String referrer, String destMobileNum) {
		this.setPhoneVCode(genSmsVfCode());
//		this.setReferrer(referrer);
		this.setDestMobileNum(destMobileNum);
		this.setValidThru(System.currentTimeMillis() + EXPIRED);
		this.setLastSent(System.currentTimeMillis());
	}
	
	/**
	 * 
	 * @description 随机生成六位数验证码
	 * @param @return   
	 * @return String    返回一个六位随机数验证码 
	 * @throws 
	 * @author 赵以宝
	 * @date 2015年12月9日 下午2:19:49
	 */
	public static String genSmsVfCode() {
		long seed = System.currentTimeMillis() + OFFSET;
		SecureRandom secureRandom = null; // 安全随机类
		try {
			secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(seed);
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage(), e);
		}
		/**
		 * 验证码数字取值范围
		 */
		String codeList = "1234567890";
		StringBuffer stringBuffer=new StringBuffer("");
		for (int i = 0; i < 6; i++) {
			/**
			 * 随即生成一个0-9之间的整数
			 */
			int code = secureRandom.nextInt(codeList.length() - 1);
			String rand = codeList.substring(code, code + 1);
			/**
			 * 将生成的随机数拼成一个六位数验证码
			 */
			stringBuffer=stringBuffer.append(rand);
		}
		/**
		 * 返回一个六位随机数验证码
		 */
		return stringBuffer.toString();

	}


	/**
	 * 随机生成十位数ValidCode码，用于邮件验证
	 * 
	 * @param
	 * @param
	 */
	public static String generateMailValidCode(int num) {
		long seed = System.currentTimeMillis() + OFFSET;
		SecureRandom secureRandom = null; // 安全随机类
		try {
			secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(seed);
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage(), e);
		}

		String codeList = "ABCDEFGHIJKLMNOPQRSTUVWXYZabckefghijklmnopqrstuvwxyz1234567890"; // 验证码数字取值范围
		StringBuffer sRand=new StringBuffer("");
		for (int i = 0; i < num; i++) {
			int code = secureRandom.nextInt(codeList.length() - 1); // 随即生成一个整数
			String rand = codeList.substring(code, code + 1);
			sRand=sRand.append(rand);
		}
		return sRand.toString(); // 返回一个六位随机数验证码
	}


	/**
	 * 验证短信验证码是否有效
	 * 
	 * @param referrer
	 * @return
	 */
	public boolean validate(String referrer, String phoneVCode, String destMobileNum) {
		boolean result = false;
//		if (this.referrer != null && referrer != null) {
			if (this.phoneVCode.equals(phoneVCode) 
				&& this.destMobileNum.equals(destMobileNum) 
				&& System.currentTimeMillis() < this.getValidThru()) {
				
				result = true;
			}
//		}
		return result;
	}

	/**
	 * 是否可以发送短信
	 * 
	 * @return
	 */
	public boolean checkShouldSendSMS(String referrer, String destMobileNum) {
		boolean result = true;
		/*
		 * logger.info(this.getReferrer() + " vs. " + referrer);
		 * logger.info(this.getDestMobileNum() + " vs. " + destMobileNum);
		 * logger.info(this.getLastSent() + " vs. " + new Date().getTime());
		 */
		if (this.getDestMobileNum() != null && this.getReferrer() != null
				&& this.getDestMobileNum().equals(destMobileNum)
				&& this.getReferrer().equals(referrer)
				&& ((this.getLastSent() + FREQ) > System.currentTimeMillis())) {
			result = false;
		}
		return result;
	}


	public String getPhoneVCode() {
		return phoneVCode;
	}

	public void setPhoneVCode(String phoneVCode) {
		this.phoneVCode = phoneVCode;
	}

	public String getReferrer() {
		return referrer;
	}

	public void setReferrer(String referrer) {
		this.referrer = referrer;
	}

	public String getDestMobileNum() {
		return destMobileNum;
	}

	public void setDestMobileNum(String destMobileNum) {
		this.destMobileNum = destMobileNum;
	}

	public long getValidThru() {
		return validThru;
	}

	public void setValidThru(long validThru) {
		this.validThru = validThru;
	}

	public long getLastSent() {
		return lastSent;
	}

	public void setLastSent(long lastSent) {
		this.lastSent = lastSent;
	}

	public int getHasAttempt() {
		return hasAttempt;
	}

	public void setHasAttempt(int hasAttempt) {
		this.hasAttempt = hasAttempt;
	}

}
