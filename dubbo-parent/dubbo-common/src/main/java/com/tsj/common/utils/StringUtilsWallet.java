package com.tsj.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import com.sun.org.apache.xpath.internal.axes.WalkingIterator;
import com.wallet.common.exception.ErrorEnum;
import com.wallet.common.exception.WalletException;
import org.apache.commons.lang3.StringUtils;


public class StringUtilsWallet {
	private static final int ORDER_NO_LENGTH = 27;
	/**
	 * @description 生成贷款订单号
	 * @return String    返回类型 
	 * @author 赵以宝
	 * @date 2017年6月29日 下午5:01:32
	 */
	public static String genLoanNo(){
		return new StringBuffer("LOAN-")
				.append(DateUtils.intoYYYYMMDD(new Date()))
				.append("-")
				.append(MD5Utils.EncoderByMd5(String.valueOf(new Date()))).toString().substring(32);
	}
	
	/**
	 * @description 生成原子支付订单号
	 * @return String    返回类型 
	 * @author 赵以宝
	 * @date 2017年6月29日 下午5:01:32
	 */
	public static String genPayAtomNo(){
		return new StringBuffer("PAYATOM-")
				.append(DateUtils.intoYYYYMMDD(new Date()))
				.append("-")
				.append(MD5Utils.EncoderByMd5(String.valueOf(new Date()))).toString().substring(32);
	}
	/**
	 * 
	 * @description 生成订单号
	 * @param prefix
	 * @return   
	 * @return String    返回类型 
	 * @throws 
	 * @author 张欢
	 * @date 2017年9月15日 下午7:08:15
	 */
	public static String genOrderNo(String prefix) throws WalletException {
        String dateStr = DateUtils.formatDateToStr(new Date(), "yyyyMMddHHmmss");
        final String dateComapny = dateStr + prefix;
        int genLength = ORDER_NO_LENGTH - dateComapny.length();
        String s = prefix + encoderByMd5(dateComapny).substring(0, genLength) + dateStr;
        return StringUtils.upperCase(s);
    }
	/**
	 *
	 * @description 生成邀请码
	 * @return
	 * @return String    返回类型
	 * @throws
	 * @author 张欢
	 * @date 2017年12月6日 下午7:08:15
	 */
	public static String genInviteNo(Integer userId) throws WalletException {
		if(userId==null){
			return null;
		}
		if(userId.toString().length()>8){
			return userId.toString();
		}
		String format = String.format("%08d", userId);
		return format;
	}
	 public static String encoderByMd5(String sourceStr) throws WalletException {
	        String result = "";
	        try {
	            MessageDigest md = MessageDigest.getInstance("MD5");
				try {
					md.update(sourceStr.getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
					throw new WalletException(ErrorEnum.ERR_ENCODING_EXCEPTION);
				}
				byte b[] = md.digest();
	            int i;
	            StringBuffer buf = new StringBuffer("");
	            for (int offset = 0; offset < b.length; offset++) {
	                i = b[offset];
	                if (i < 0) {
                        i += 256;
                    }
	                if (i < 16) {
                        buf.append("0");
                    }
	                buf.append(Integer.toHexString(i));
	            }
	            result = buf.toString();
	        } catch (NoSuchAlgorithmException e) {
	            System.out.println(e);
	        }
	        return result;
	    }
}
