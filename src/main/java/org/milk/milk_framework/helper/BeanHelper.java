package org.milk.milk_framework.helper;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.milk.milk_framework.util.ReflectionUtil;

/**
 *@author 田超哲
 *@date 2016年2月21日下午4:57:01
 *功能:Bean助手类
 */
public final class BeanHelper {
	/**
	 * 定义Bean映射(用于存放Bean类与Bean实例的映射关系)
	 */
	public static final Map<Class<?>,Object> BEAN_MAP = new HashMap<>();
	
	static{
		Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
		for(Class<?> beanClass:beanClassSet){
			Object obj = ReflectionUtil.newInstance(beanClass);
			BEAN_MAP.put(beanClass, obj);
		}
	}
	/**
	 * 获取Bean映射
	 */
	public static Map<Class<?>,Object> getBeanMap(){
		return BEAN_MAP;
	}
	/**
	 * 获取Bean实例
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> cls){
		if(!BEAN_MAP.containsKey(cls)){
			throw new RuntimeException("can not get bean by class: "+cls);
		}
		return (T)BEAN_MAP.get(cls);
	}
	/**
	 * 设置Bean实例
	 */
	public static void setBean(Class<?> cls,Object obj){
		BEAN_MAP.put(cls, obj);
	}

}
