package org.milk.milk_framework.util;

import java.net.URLDecoder;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *@author 田超哲
 *@date 2016年2月21日下午11:22:10
 *功能:编码与解码操作工具类
 */
public final class CodecUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(CodecUtil.class);
	/**
	 * 将URL编码
	 */
	public static String encodeURL(String source,String charset){
		String target;
		try{
			target = URLEncoder.encode(source, charset);
		}catch(Exception e){
			LOGGER.error("encode url failure",e);
			throw new RuntimeException(e);
		}
		return target;
	}
	/**
	 * 将URL解编码
	 */
	public static String decodeURL(String source,String charset){
		String target;
		try{
			target = URLDecoder.decode(source, charset);
		}catch(Exception e){
			LOGGER.error("decode url failure",e);
			throw new RuntimeException(e);
		}
		return target;
	}

}
