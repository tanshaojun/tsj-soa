package com.tsj.common.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

public class StringUtilsAwue {
	/**
	 * @description 加密PID
	 * @param sourceId 
	 * @param sourceType 
	 * @return String    返回类型 
	 * @author hxt
	 * @date 2016年12月20日 下午5:01:32
	 */
	public static String generatePid(int souId,int souType){
		
		String suoIdStr =  String.format( "%08d", souId);
		String souTypeString = String.format("%04d", souType);

		
		StringBuffer result = new StringBuffer();
		String randStr = RandomStringUtils.randomAlphanumeric(16);
		
		result.append(souTypeString.substring(0, 2));
		for (int i = 0; i < 16; i++) {
			if(i%2 == 0){
				result.append(randStr.substring(i, i+2));
				result.append(suoIdStr.substring(i/2, i/2+1));
			}
		}
		result.append(souTypeString.substring(2, 4));
		return result.toString();
	}
	
	/**
	 * @description 根据pId获取  sourceType   sourceId
	 * @param pId 长度必须为28位，
	 * @return Map<String,String>    key1 = sourceType  key2 = sourceId 
	 * @author hxt
	 * @date 2016年12月20日 下午5:02:53
	 */
	public static Map<String, Integer> getIdAndType(String pId){
		if(StringUtils.isBlank(pId) || pId.length() != 28){
			return null;
		}
		String sourceType = pId.substring(0,2) + pId.substring(26,28);
		StringBuffer sourceId = new StringBuffer();
		
		String u = pId.substring(2,26); 
		for (int i = 0; i < 26; i++) {
			if(i!=0 && i%3 == 0){
				sourceId.append(u.substring(i-1, i));
			}
		}
		Map<String, Integer> map = new HashMap<>(16);
		map.put("sourceType", Integer.parseInt(sourceType));
		map.put("sourceId", Integer.parseInt(sourceId.toString()));
		return map;
	}
	
	public static void main(String[] args) {
		String e =generatePid(123,4);
		System.out.println(e);
		System.out.println("--------------");
		Map<String, Integer> map = getIdAndType(e);
		System.out.println(map.get("sourceType"));
		System.out.println(map.get("sourceId"));
	}
}
