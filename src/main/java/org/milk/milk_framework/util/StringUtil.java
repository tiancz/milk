package org.milk.milk_framework.util;

/**
 *@author 田超哲
 *@date 2016年2月21日下午1:43:13
 *功能:字符串工具类
 */
public final class StringUtil {
	//字符串分隔符
	public static final String SEPARATOR = String.valueOf((char) 29);
	/**
	 * 判断字符串是否为空
	 */
	public static boolean isEmpty(String str){
		if(str!=null)
			str = str.trim();
		return str.isEmpty();
//		StringUtils.isEmpty(str);
	}
	/**
	 * 判断字符串是否非空
	 */
	public static boolean isNotEmpty(String str){
		return !isEmpty(str);
	}
	/**
	 * 用指定字符切割字符串
	 */
	public static String[] splitString(String str,String regexp){
		return str.split(regexp);
	}

}
