package org.milk.milk_framework.helper;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

import org.milk.milk_framework.annotation.Controller;
import org.milk.milk_framework.annotation.Service;
import org.milk.milk_framework.util.ClassUtil;

/**
 *@author �ﳬ��
 *@date 2016��2��21������3:24:02
 *����:�����������
 */

public final class ClassHelper {
	/**
	 * �����༯�ϣ����ڴ�Ŷ���ص��ࣩ
	 */
	private static final Set<Class<?>> CLASS_SET;
	
	static{
		String basePackage = ConfigHelper.getAppBasePackage();
		CLASS_SET = ClassUtil.getClassSet(basePackage);
	}
	/**
	 * ��ȡӦ�ð����µ�������
	 */
	public static Set<Class<?>> getClassSet(){
		return CLASS_SET;
	}
	/**
	 * ��ȡӦ�ð���������Service��
	 */
	public static Set<Class<?>> getServiceClassSet(){
		Set<Class<?>> classSet = new HashSet<>();
		for(Class<?> cls:CLASS_SET){
			if(cls.isAnnotationPresent(Service.class))
				classSet.add(cls);
		}
		return classSet;
	}
	/**
	 * ��ȡӦ�ð���������Controller��
	 */
	public static Set<Class<?>> getControllerClassSet(){
		Set<Class<?>> classSet = new HashSet<>();
		for (Class<?> cls : CLASS_SET) {
			if(cls.isAnnotationPresent(Controller.class))
				classSet.add(cls);
		}
		return classSet;
	}
	/**
	 * ��ȡӦ�ð��������е�Bean�ࣨ������Service��Controller�ȣ�
	 */
	public static Set<Class<?>> getBeanClassSet(){
		Set<Class<?>> beanClassSet = new HashSet<>();
		beanClassSet.addAll(getServiceClassSet());
		beanClassSet.addAll(getControllerClassSet());
		return beanClassSet;
	}
	/**
	 * ��ȡӦ�ð�����ĳ���ࣨ��ӿڣ����������ࣨ��ʵ���ࣩ
	 */
	public static Set<Class<?>> getClassSetBySuper(Class<?> superClass){
		Set<Class<?>> classSet = new HashSet<>();
		for(Class<?> cls:CLASS_SET){
			if(superClass.isAssignableFrom(cls)&&!superClass.equals(cls)){
				classSet.add(cls);
			}
		}
		return classSet;
	}
	/**
	 * ��ȡӦ�ð����´���ĳע���������
	 */
	public static Set<Class<?>> getClassSetByAnnotation(Class<? extends Annotation> annotationClass){
		Set<Class<?>> classSet = new HashSet<>();
		for(Class<?> cls:CLASS_SET){
			if(cls.isAnnotationPresent(annotationClass)){
				classSet.add(cls);
			}
		}
		return classSet;
	}
}
