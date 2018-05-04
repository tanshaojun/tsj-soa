package com.tsj.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 加密类
 *
 */
public class MD5Utils{
	private static Logger logger = LoggerFactory.getLogger(MD5Utils.class);

	// 加的盐
	private static final String SALT = "HXWcjvQWVG1wI4FQBLZpQ3pWj48AV63d";

	public static String EncoderByMd5(String buf) {
		try {
			MessageDigest digist = MessageDigest.getInstance("MD5");
			byte[] rs = new byte[0];
			try {
				rs = digist.digest(buf.getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			StringBuffer digestHexStr = new StringBuffer();
			for (int i = 0; i < 16; i++) {
				digestHexStr.append(byteHEX(rs[i]));
			}
			return digestHexStr.toString();
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage(), e);
		}
		return null;

	}

    /****
     * @param inbuf 前台传入已加密的密码
     * @version 3.0
     */
	public static String encodeByMd5AndSalt(String inbuf) {
		//生成16位的随机数
		String randomStr=RandomStrUtil.getRandomString(16);
		String newMd5Pwd= EncoderByMd5(inbuf + randomStr)+randomStr;
		return newMd5Pwd;
	}

	public static void main(String[] args) {
		System.out.println(EncoderByMd5("123456"));
		String aa="123456";
		System.out.println(MD5Utils.encodeByMd5(MD5Utils.encodeByMd5(aa.trim()) + "HXWcjvQWVG1wI4FQBLZpQ3pWj48AV63d"));
		System.out.println(encodeByMd5AndSalt("c475d3bf6d95f3d7c6e7d0becdaa33d0"));
		System.out.println(encodeByMd5AndSalt("40F99E3F6967057C44DD6A7F89390B64"));
		System.out.println(VerifyPassWord("c475d3bf6d95f3d7c6e7d0becdaa33d0","620AE7E15D97D5EB1C9CB295325134B2YhgHbbeTzJgrkLgt"));
		System.out.println(VerifyPassWord("40F99E3F6967057C44DD6A7F89390B64","c475d3bf6d95f3d7c6e7d0becdaa33d0"));
		System.out.println(VerifyPassWord("c475d3bf6d95f3d7c6e7d0becdaa33d0","C8CF74F8F69F70BBB1D9038929EF9298TSw1XR4d2SD5CNdu"));
		System.out.println(EncoderByMd5("123456"));
//		System.out.println(encodeByMd5AndSalt("E10ADC3949BA59ABBE56E057F20F883E"));
//		System.out.println(VerifyPassWord("E10ADC3949BA59ABBE56E057F20F883E","E2170DB6982D79A576952F737BCC6F25dce8jWobhdSZtxkh"));
		System.out.println(EncoderByMd5("1234qwer").toLowerCase());


		//System.out.println(encodeByMd5AndSalt("E10ADC3949BA59ABBE56E057F20F883E"));
	}
	public static String encodeByMd5AndSaltAdmin(String inbuf) {
		return EncoderByMd5(EncoderByMd5(inbuf) + SALT);
	}
	
	
	public static String encodeByMd5(String inbuf) {
		return EncoderByMd5(inbuf);
	}
	
	
	public static String byteHEX(byte ib) {
		char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
				'B', 'C', 'D', 'E', 'F' };
		char[] ob = new char[2];
		ob[0] = Digit[(ib >>> 4) & 0X0F];
		ob[1] = Digit[ib & 0X0F];
		String s = new String(ob);
		return s;
	}
	
	 //传入的密码进行截取然后进行
	/***
	 * 传入前台加密的密码,和用户原始的密码
	 * @param inputMD5Password  前台加密的用户密码
  	 * @param userPassword    数据库中储存的密码
	 * @version 3.0
	 */
	public static Boolean VerifyPassWord(String inputMD5Password ,String userPassword){
		if (userPassword == null || inputMD5Password == null) {
            return false;
        }
		
		String passWordBehindRandomStr=userPassword.substring(userPassword.length()-16, userPassword.length());
		
		String encryptionPassword=EncoderByMd5(inputMD5Password+passWordBehindRandomStr)+passWordBehindRandomStr;
		if (encryptionPassword.equals(userPassword)) {
			//密码正确
			return true;
		}else{
		    //密码错误
			return false;	
		}
	}


}
