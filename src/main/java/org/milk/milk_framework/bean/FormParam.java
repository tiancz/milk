package org.milk.milk_framework.bean;
/**
 *@author 田超哲
 *@date 2016年3月10日下午9:47:47
 *@功能:封装表单参数
 */
public class FormParam {
	private String fieldName;
	private Object fieldValue;
	public FormParam(String fieldName, Object fieldValue) {
		super();
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	public String getFieldName() {
		return fieldName;
	}
	public Object getFieldValue() {
		return fieldValue;
	}

}
