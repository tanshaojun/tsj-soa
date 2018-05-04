package com.tsj.common.utils;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import com.wallet.common.exception.ErrorEnum;
import com.wallet.common.exception.WalletException;
import org.apache.commons.codec.binary.Base64;

public class RequestParameterUtils {
	/**
	 * 
	 * @description 将get方式传递的参数将key和value解析成map
	 * @param URL
	 * @return   
	 * @return Map<String,String>    返回类型 
	 * @throws 
	 * @author （ 元元写的）
	 * @date 2017年8月9日 下午4:01:13
	 */
	 public static Map<String, String> URLRequest(String URL) {
        Map<String, String> mapRequest = new HashMap<String, String>(16);
        String[] arrSplit = URL.split("[&]");
        for (String strSplit : arrSplit) {
            String[] arrSplitEqual = null;
            arrSplitEqual = strSplit.split("[=]");
            // 解析出键值
            if (arrSplitEqual.length > 1) {
                mapRequest.put(arrSplitEqual[0], arrSplitEqual[1]);
            }
        }
        return mapRequest;
	 }
	 /**
	  * 
	  * @description 先将参数解码再解析参数,返回参数的map
	  * @param url
	  * @return   
	  * @return Map<String,String>    返回类型 
	 * @throws UnsupportedEncodingException 
	  * @throws 
	  * @author 段华微
	  * @date 2017年8月9日 下午4:02:31
	  */
	 public static Map<String, String> URLRequestDecodeByBase64(String url) throws WalletException {
		 url = url.replaceAll(" ", "+");
		 try {
			 url = new String(Base64.decodeBase64(url.getBytes("UTF-8")));
		 } catch (UnsupportedEncodingException e) {
			 e.printStackTrace();
			 throw new WalletException(ErrorEnum.ERR_ENCODING_EXCEPTION);
		 }
		 Map<String, String> mapRequest = new HashMap<String, String>(16);
		 String[] arrSplit = url.split("[&]");
		 for (String strSplit : arrSplit) {
			 String[] arrSplitEqual = null;
			 arrSplitEqual = strSplit.split("[=]");
			 // 解析出键值
			 if (arrSplitEqual.length > 1) {
				 mapRequest.put(arrSplitEqual[0], arrSplitEqual[1]);
			 }
		 }
		 return mapRequest;
	 }
}
