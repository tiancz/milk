package org.milk.milk_framework.bean;
/**
 *@author �ﳬ��
 *@date 2016��3��10������9:47:47
 *@����:��װ������
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
