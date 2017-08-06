package org.milk.milk_framework.util;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;

/**
 *@author 田超哲
 *@date 2016年2月21日下午6:54:12
 *功能:容器工具类
 */
public final class CollectionUtil {

//	判断collection是否为空
	public static boolean isEmpty(Collection<?> collection){
		return CollectionUtils.isEmpty(collection);
	}
//	判断collection是否为空
	public static boolean isNotEmpty(Collection<?> collection){
		return !isEmpty(collection);
	}
	/**
	 * 判断Map是否非空
	 */
	public static boolean isNotEmpty(Map<?,?> map){
		return !isEmpty(map);
	}
	/**
	 * 判断Map是否为空
	 */
	public static boolean isEmpty(Map<?,?> map){
		return map.isEmpty();
//		return MapUtils.isEmpty(map);
	}
	/**
	 * 判断Set是否非空
	 */
	public static boolean isNotEmpty(Set<?> set){
		return !isEmpty(set);
	}
	/**
	 * 判断Set是否为空
	 */
	public static boolean isEmpty(Set<?> set){
		return set.isEmpty();
	}
	/**
	 * 判断List是否非空
	 */
//	public static boolean isNotEmpty(List<?> list){
//		return !isEmpty(list);
//	}
//	/**
//	 * 判断List是否为空
//	 */
//	public static boolean isEmpty(List<?> list){
////		return list.size()==0;
//		return list.isEmpty();
//	}

}
