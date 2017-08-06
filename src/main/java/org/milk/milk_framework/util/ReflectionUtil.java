package org.milk.milk_framework.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *@author �ﳬ��
 *@date 2016��2��21������4:46:09
 *����:���乤����
 */
public final class ReflectionUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionUtil.class);
	/**
	 * ����ʵ��
	 */
	public static Object newInstance(Class<?> cls){
		Object instance;
		try{
			instance = cls.newInstance();
		}catch(Exception e){
			LOGGER.error("new instance failure",e);
			throw new RuntimeException(e);
		}
		return instance;
	}
	/**
	 * ���÷���
	 */
	public static Object invokeMethod(Object obj,Method method,Object...args){
		Object result;
		try {
			method.setAccessible(true);
			result = method.invoke(obj, args);
		} catch (Exception e) {
			LOGGER.error("invoke method failure",e);
			throw new RuntimeException(e);
		}
		return result;
	}
	/**
	 * ���ó�Ա������ֵ
	 */
	public static void setField(Object obj,Field field,Object value){
		try {
			field.setAccessible(true);
			field.set(obj, value);
		} catch (Exception e) {
			LOGGER.error("set field failure",e);
			throw new RuntimeException(e);
		}
		
	}

}
