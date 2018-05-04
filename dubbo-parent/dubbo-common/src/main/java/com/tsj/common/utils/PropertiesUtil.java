package com.tsj.common.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;

public class PropertiesUtil {

	private static Map<String, Properties> propsMap = new HashMap<String, Properties>();

	public static String getProperty(String propertyKey, String propertyFileName) {
		if (propsMap.containsKey(propertyFileName)) {
			return propsMap.get(propertyFileName).getProperty(propertyKey);
		}
		String value = null;
		try {
			Properties props = PropertiesLoaderUtils
					.loadAllProperties(propertyFileName);
			value = props.getProperty(propertyKey);
			propsMap.put(propertyFileName, props);
		} catch (IOException e) {
			System.out.println(propertyFileName + "文件未找到");
			e.printStackTrace();
		}
		return value;
	}

}
