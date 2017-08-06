package org.milk.milk_framework.util;

/**
 *@author 田超哲
 *@date 2016年2月21日下午6:54:24
 *功能:数组工具类
 */
public final class ArrayUtil {
	/**
	 * 判断数组是否非空
	 */
	public static boolean isNotEmpty(Object[]array){
		return array.length>0;
//		!ArrayUtils.isEmpty(array);
	}
	/**
	 * 判断数组是否为空
	 */
	public static boolean isEmpty(Object[]array){
		return array.length==0;
//		ArrayUtils.isEmpty(array);
	}

}
