package org.milk.milk_framework.util;

/**
 *@author �ﳬ��
 *@date 2016��2��21������6:54:24
 *����:���鹤����
 */
public final class ArrayUtil {
	/**
	 * �ж������Ƿ�ǿ�
	 */
	public static boolean isNotEmpty(Object[]array){
		return array.length>0;
//		!ArrayUtils.isEmpty(array);
	}
	/**
	 * �ж������Ƿ�Ϊ��
	 */
	public static boolean isEmpty(Object[]array){
		return array.length==0;
//		ArrayUtils.isEmpty(array);
	}

}
