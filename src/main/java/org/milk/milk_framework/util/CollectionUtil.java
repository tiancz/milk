package org.milk.milk_framework.util;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;

/**
 *@author �ﳬ��
 *@date 2016��2��21������6:54:12
 *����:����������
 */
public final class CollectionUtil {

//	�ж�collection�Ƿ�Ϊ��
	public static boolean isEmpty(Collection<?> collection){
		return CollectionUtils.isEmpty(collection);
	}
//	�ж�collection�Ƿ�Ϊ��
	public static boolean isNotEmpty(Collection<?> collection){
		return !isEmpty(collection);
	}
	/**
	 * �ж�Map�Ƿ�ǿ�
	 */
	public static boolean isNotEmpty(Map<?,?> map){
		return !isEmpty(map);
	}
	/**
	 * �ж�Map�Ƿ�Ϊ��
	 */
	public static boolean isEmpty(Map<?,?> map){
		return map.isEmpty();
//		return MapUtils.isEmpty(map);
	}
	/**
	 * �ж�Set�Ƿ�ǿ�
	 */
	public static boolean isNotEmpty(Set<?> set){
		return !isEmpty(set);
	}
	/**
	 * �ж�Set�Ƿ�Ϊ��
	 */
	public static boolean isEmpty(Set<?> set){
		return set.isEmpty();
	}
	/**
	 * �ж�List�Ƿ�ǿ�
	 */
//	public static boolean isNotEmpty(List<?> list){
//		return !isEmpty(list);
//	}
//	/**
//	 * �ж�List�Ƿ�Ϊ��
//	 */
//	public static boolean isEmpty(List<?> list){
////		return list.size()==0;
//		return list.isEmpty();
//	}

}
