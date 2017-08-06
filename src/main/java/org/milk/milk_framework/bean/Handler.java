package org.milk.milk_framework.bean;

import java.lang.reflect.Method;

/**
 *@author �ﳬ��
 *@date 2016��2��21������7:30:41
 *����:��װAction��Ϣ
 */
public class Handler {
	/**
	 * Controller ��
	 */
	private Class<?>controllerClass;
	/**
	 * Action����
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
