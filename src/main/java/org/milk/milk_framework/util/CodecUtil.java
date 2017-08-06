package org.milk.milk_framework.util;

import java.net.URLDecoder;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *@author �ﳬ��
 *@date 2016��2��21������11:22:10
 *����:������������������
 */
public final class CodecUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(CodecUtil.class);
	/**
	 * ��URL����
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
	 * ��URL�����
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
