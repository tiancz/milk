package org.milk.milk_framework.bean;

import java.util.HashMap;
import java.util.Map;

/**
 *@author �ﳬ��
 *@date 2016��2��21������8:33:42
 *����:������ͼ����
 */
public class View {
	/**
	 * ��ͼ·��
	 */
	private String path;
	/**
	 * ģ������
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
