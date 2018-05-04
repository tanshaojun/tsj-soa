package com.tsj.common.utils;

import com.alibaba.fastjson.serializer.SerializerFeature;

public class JSONUtil {

	public static SerializerFeature[] getSerializerFeatures() {
		SerializerFeature[] features = { SerializerFeature.WriteMapNullValue, // 输出空置字段
				SerializerFeature.WriteNullListAsEmpty, // list字段如果为null，输出为[]，而不是null
				SerializerFeature.WriteNullNumberAsZero, // 数值字段如果为null，输出为0，而不是null
				SerializerFeature.WriteNullBooleanAsFalse, // Boolean字段如果为null，输出为false，而不是null
				SerializerFeature.WriteNullStringAsEmpty, // 字符类型字段如果为null，输出为""，而不是null
				SerializerFeature.WriteNonStringKeyAsString,//如果key不为String 则转换为String 比如Map的key为Integer  
				SerializerFeature.DisableCircularReferenceDetect//循环依赖
		};
		return features;
	}
}
