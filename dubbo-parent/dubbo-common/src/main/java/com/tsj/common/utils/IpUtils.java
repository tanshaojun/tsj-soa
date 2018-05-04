package com.tsj.common.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @description IP地址工具类
 * @ClassName: IpUtils
 * @version V1.0
 * @author 赵以宝
 * @Date 2016年7月15日 上午9:05:55
 * Copyright(c) 2015 www.wallet.com  All rights reserved
 *
 */

public class IpUtils {

	private static Logger logger = LoggerFactory.getLogger(IpUtils.class);
	
	
	/**
	 * 
	 * @description 获取客户端浏览器的ip地址
	 * @param request
	 * @return   
	 * @return String    返回类型 
	 * @throws 
	 * @author 赵以宝
	 * @date 2016年7月15日 上午9:06:15
	 */
	public static String getIpAddress(HttpServletRequest request) {
		//如果使用反向代理，从转发请求中获取
		String ip = request.getHeader("x-forwarded-for");

		logger.debug("获取客户端浏览器ip地址 ：");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip != null && ip.indexOf(":") >= 0) { // 判断是否为IPV6地址
			ip = "127.0.0.1";
		}
		logger.debug("IP = "+ip);
		return ip;
	}

	// 將IP地址转换成10进制整数
	public static Integer IpToLong(String strIp)
	{
		logger.debug("Ip地址转换成10进制整数 start：");
		long[] ip = new long[4];
		// 先找到IP地址字符串中.的位置
		int position1 = strIp.indexOf(".");
		int position2 = strIp.indexOf(".", position1 + 1);
		int position3 = strIp.indexOf(".", position2 + 1);
		// 将每个.之间的字符串转换成整型
		ip[0] = Integer.parseInt(strIp.substring(0, position1));
		ip[1] = Integer.parseInt(strIp.substring(position1 + 1, position2));
		ip[2] = Integer.parseInt(strIp.substring(position2 + 1, position3));
		ip[3] = Integer.parseInt(strIp.substring(position3 + 1));
		return (int) ((ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3]);
	}

	// 将十进制整数形式转换成127.0.0.1形式的ip地址
	public static String LongToIP(Integer longIp)
	{
		StringBuffer sb = new StringBuffer("");
		// 直接右移24位
		sb.append(String.valueOf((longIp >>> 24)));
		sb.append(".");
		// 将高8位置0，然后右移16位
		sb.append(String.valueOf((longIp & 0x00FFFFFF) >>> 16));
		sb.append(".");
		// 将高16位置0，然后右移8位
		sb.append(String.valueOf((longIp & 0x0000FFFF) >>> 8));
		sb.append(".");
		// 将高24位置0
		sb.append(String.valueOf((longIp & 0x000000FF)));
		return sb.toString();
	}
	
	/**
	 * @description 通过Ip获取省份地址
	 * @param content   请求的参数 格式为：name=xxx&pwd=xxx   ip=xxx
	 * @param encodingString   服务器端请求编码。如GBK,UTF-8等
	 * @throws UnsupportedEncodingException   
	 * @return Map< String, Object>    返回类型 
	 * @date 2016年5月20日 上午9:30:42
	 */
	public static Map< String, Object> getAddresses(String content, String encodingString)
			throws UnsupportedEncodingException {
		// 这里调用pconline的接口
		String urlStr = "http://ip.taobao.com/service/getIpInfo.php";
		String returnStr = IpUtils.getResult(urlStr, content, encodingString);
		if (returnStr != null) {
			// 处理返回的省市区信息
			String[] temp = returnStr.split(",");
			if (temp.length < 3) {
				return null;// 无效IP，局域网测试
			}
			Map< String, Object> addressMap = new HashMap<String, Object>(16);
			String region = (temp[5].split(":"))[1].replaceAll("\"", "");
			region = decodeUnicode(region);// 省份
			String city = (temp[7].split(":"))[1].replaceAll("\"", "");
			city = decodeUnicode(city);//市区 
			addressMap.put("region", region);//省份
			addressMap.put("city", city);//城市
			return addressMap;
		}
		return null;
	}

	/**
	 * @description 描述该函数完成什么功能
	 * @param urlStr  请求的地址
	 * @param content   请求的参数 格式为：name=xxx&pwd=xxx    或   ip=xxx
	 * @param encoding   服务器端请求编码。如GBK,UTF-8等
	 * @return String    返回类型 
	 * @date 2016年5月20日 上午9:28:27
	 */
	private static String getResult(String urlStr, String content, String encoding) {
		URL url = null;
		HttpURLConnection connection = null;
		try {
			url = new URL(urlStr);
			connection = (HttpURLConnection) url.openConnection();// 新建连接实例
			//connection.setConnectTimeout(300000);// 设置连接超时时间，单位毫秒
			//connection.setReadTimeout(300000);// 设置读取数据超时时间，单位毫秒
			connection.setDoOutput(true);// 是否打开输出流 true|false
			connection.setDoInput(true);// 是否打开输入流true|false
			connection.setRequestMethod("POST");// 提交方法POST|GET
			connection.setUseCaches(false);// 是否缓存true|false
			connection.connect();// 打开连接端口
			DataOutputStream out = new DataOutputStream(connection.getOutputStream());// 打开输出流往对端服务器写数据
			out.writeBytes(content);// 写数据,也就是提交你的表单 name=xxx&pwd=xxx
			out.flush();// 刷新
			out.close();// 关闭输出流
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), encoding));// 往对端写完数据对端服务器返回数据
			// 以BufferedReader流来读取
			StringBuffer buffer = new StringBuffer();
			String line = "";
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			reader.close();
			return buffer.toString();
		} catch (IOException e) {
			//e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.disconnect();// 关闭连接
			}
		}
		return null;
	}

	/**
	 * 
	 * @description unicode 转换成 中文
	 * @param theString
	 * @return String  
	 * @date 2016年5月20日 上午9:21:30
	 */
	public static String decodeUnicode(String theString) {
		char aChar;
		int len = theString.length();
		StringBuffer outBuffer = new StringBuffer(len);
		for (int x = 0; x < len;) {
			aChar = theString.charAt(x++);
			if (aChar == '\\') {
				aChar = theString.charAt(x++);
				if (aChar == 'u') {
					int value = 0;
					for (int i = 0; i < 4; i++) {
						aChar = theString.charAt(x++);
						switch (aChar) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							value = (value << 4) + aChar - '0';
							break;
						case 'a':
						case 'b':
						case 'c':
						case 'd':
						case 'e':
						case 'f':
							value = (value << 4) + 10 + aChar - 'a';
							break;
						case 'A':
						case 'B':
						case 'C':
						case 'D':
						case 'E':
						case 'F':
							value = (value << 4) + 10 + aChar - 'A';
							break;
						default:
							throw new IllegalArgumentException("无效的unicode");
						}
					}
					outBuffer.append((char) value);
				} else {
					if (aChar == 't') {
						aChar = '\t';
					} else if (aChar == 'r') {
						aChar = '\r';
					} else if (aChar == 'n') {
						aChar = '\n';
					} else if (aChar == 'f') {
						aChar = '\f';
					}
					outBuffer.append(aChar);
				}
			} else {
				outBuffer.append(aChar);
			}
		}
		return outBuffer.toString();
	}

	/**
	 * 
	 * @description 根据URL参数的Key，获取value；
	 * @param URLKey
	 * @return String    返回类型 
	 * @date 2016年5月20日 下午2:30:26
	 */
	public static String getURLParameter(String url,String urlKey){
		if(url==null || "".equals(url)){
			return null;
		}
		url = url.substring(url.indexOf("?")+1, url.length());
		String arrReffer[] = url.split("&");
		for (String s : arrReffer) {
			if(s.indexOf(urlKey+"=")>-1){
				return s.substring(s.indexOf("=")+1,s.length());
			}
		}
		return null;
	}

	/**
	 * @description 通过cookieKEY获取cookie值
	 * @param cookies
	 * @param cookieKie
	 * @return String    返回类型 
	 * @date 2016年5月25日 上午10:46:20
	 */
	public static String getCookieValue(Cookie cookies[],String cookieKie){
		if(cookies==null){
			return null;
		}
		for (int i = 0; i < cookies.length; i++){    
	       Cookie c = cookies[i];         
	       if(c.getName().equalsIgnoreCase(cookieKie)){    
	          return c.getValue();    
	        }   
		}
		return null;
	}


}
