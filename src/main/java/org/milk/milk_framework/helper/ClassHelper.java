package org.milk.milk_framework.helper;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

import org.milk.milk_framework.annotation.Controller;
import org.milk.milk_framework.annotation.Service;
import org.milk.milk_framework.util.ClassUtil;

/**
 *@author 田超哲
 *@date 2016年2月21日下午3:24:02
 *功能:类操作助手类
 */

public final class ClassHelper {
	/**
	 * 定义类集合（用于存放多加载的类）
	 */
	private static final Set<Class<?>> CLASS_SET;
	
	static{
		String basePackage = ConfigHelper.getAppBasePackage();
		CLASS_SET = ClassUtil.getClassSet(basePackage);
	}
	/**
	 * 获取应用包名下的所有类
	 */
	public static Set<Class<?>> getClassSet(){
		return CLASS_SET;
	}
	/**
	 * 获取应用包名下所有Service类
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
	 * 获取应用包名下所有Controller类
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
	 * 获取应用包名下所有的Bean类（包括：Service、Controller等）
	 */
	public static Set<Class<?>> getBeanClassSet(){
		Set<Class<?>> beanClassSet = new HashSet<>();
		beanClassSet.addAll(getServiceClassSet());
		beanClassSet.addAll(getControllerClassSet());
		return beanClassSet;
	}
	/**
	 * 获取应用包名下某父类（或接口）的所有子类（或实现类）
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
	 * 获取应用包名下带有某注解的所有类
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
