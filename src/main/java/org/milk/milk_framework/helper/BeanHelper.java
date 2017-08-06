package org.milk.milk_framework.helper;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.milk.milk_framework.util.ReflectionUtil;

/**
 *@author �ﳬ��
 *@date 2016��2��21������4:57:01
 *����:Bean������
 */
public final class BeanHelper {
	/**
	 * ����Beanӳ��(���ڴ��Bean����Beanʵ����ӳ���ϵ)
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
	 * ��ȡBeanӳ��
	 */
	public static Map<Class<?>,Object> getBeanMap(){
		return BEAN_MAP;
	}
	/**
	 * ��ȡBeanʵ��
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> cls){
		if(!BEAN_MAP.containsKey(cls)){
			throw new RuntimeException("can not get bean by class: "+cls);
		}
		return (T)BEAN_MAP.get(cls);
	}
	/**
	 * ����Beanʵ��
	 */
	public static void setBean(Class<?> cls,Object obj){
		BEAN_MAP.put(cls, obj);
	}

}
