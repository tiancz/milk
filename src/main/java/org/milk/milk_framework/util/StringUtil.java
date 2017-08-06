package org.milk.milk_framework.util;

/**
 *@author �ﳬ��
 *@date 2016��2��21������1:43:13
 *����:�ַ���������
 */
public final class StringUtil {
	//�ַ����ָ���
	public static final String SEPARATOR = String.valueOf((char) 29);
	/**
	 * �ж��ַ����Ƿ�Ϊ��
	 */
	public static boolean isEmpty(String str){
		if(str!=null)
			str = str.trim();
		return str.isEmpty();
//		StringUtils.isEmpty(str);
	}
	/**
	 * �ж��ַ����Ƿ�ǿ�
	 */
	public static boolean isNotEmpty(String str){
		return !isEmpty(str);
	}
	/**
	 * ��ָ���ַ��и��ַ���
	 */
	public static String[] splitString(String str,String regexp){
		return str.split(regexp);
	}

}
