package org.milk.milk_framework.bean;
/**
 *@author 田超哲
 *@date 2016年2月21日下午8:37:17
 *功能:返回数据对象
 */
public class Data {
	/**
	 * 模型数据
	 */
	private Object model;
	
	public Data(Object model){
		this.model = model;
	}
	public Object getModel(){
		return model;
	}

}
