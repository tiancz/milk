package org.milk.milk_framework.bean;

import java.util.HashMap;
import java.util.Map;

/**
 *@author 田超哲
 *@date 2016年2月21日下午8:33:42
 *功能:返回视图对象
 */
public class View {
	/**
	 * 视图路径
	 */
	private String path;
	/**
	 * 模型数据
	 */
	private Map<String,Object> model;
	
	public View(String path){
		this.path = path;
		model = new HashMap<>();
	}
	public View addModel(String key,Object value){
		model.put(key, value);
		return this;
	}
	public String getPath() {
		return path;
	}
	public Map<String, Object> getModel() {
		return model;
	}
	

}
