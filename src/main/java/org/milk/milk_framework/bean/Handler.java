package org.milk.milk_framework.bean;

import java.lang.reflect.Method;

/**
 *@author 田超哲
 *@date 2016年2月21日下午7:30:41
 *功能:封装Action信息
 */
public class Handler {
	/**
	 * Controller 类
	 */
	private Class<?>controllerClass;
	/**
	 * Action方法
	 */
	private Method actionMethod;
	
	public Handler(Class<?>controllerClass,Method actionMethod){
		this.controllerClass = controllerClass;
		this.actionMethod = actionMethod;
	}
	public Class<?> getControllerClass() {
		return controllerClass;
	}
	public Method getActionMethod() {
		return actionMethod;
	}
}
