package org.milk.milk_framework.util;
/**
 *@author 田超哲
 *@date 2016年2月21日下午1:28:38
 *功能:转型操作工具类
 */
public final class CastUtil {
	/**
	 * 转为String
	 */
	public static String castString(Object obj){
		return CastUtil.castString(obj,"");
	}
	/**
	 * 转为String,提供默认值
	 */
	public static String castString(Object obj,String defaultValue){
		return obj!=null?String.valueOf(obj):defaultValue;
	}
	/**
	 * 转为double
	 */
	public static double castDouble(Object obj){
		return CastUtil.castDouble(obj,0);
	}
	/**
	 * 转为double,提供默认值
	 */
	public static double castDouble(Object obj,double defaultValue){
		double doubleValue = defaultValue;
		if(obj!=null){
			String strValue = castString(obj);
			if(strValue!=null){
				try{
					doubleValue = Double.parseDouble(strValue);
				}catch(NumberFormatException e){
					doubleValue = defaultValue;
				}
			}
		}
		return doubleValue;
	}
	/**
	 * 转为long
	 */
	public static long castLong(Object obj){
		return CastUtil.castLong(obj,0);
	}
	/**
	 * 转为String,提供默认值
	 */
	public static long castLong(Object obj,long defaultValue){
		long longValue = defaultValue;
		if(obj!=null){
			String strValue = castString(obj);
			if(strValue!=null){
				try{
					longValue = Long.parseLong(strValue);
				}catch(NumberFormatException e){
					longValue = defaultValue;
				}
			}
		}
		return longValue;
	}
	/**
	 * 转为int
	 */
	public static int castInt(Object obj){
		return CastUtil.castInt(obj,0);
	}
	/**
	 * 转为int,提供默认值
	 */
	public static int castInt(Object obj,int defaultValue){
		int intValue = defaultValue;
		if(obj!=null){
			String strValue = castString(obj);
			if(strValue!=null){
				try{
					intValue = Integer.parseInt(strValue);
				}catch(NumberFormatException e){
					intValue = defaultValue;
				}
			}
		}
		return intValue;
	}
	/**
	 * 转为boolean
	 */
	public static boolean castBoolean(Object obj){
		return CastUtil.castBoolean(obj,false);
	}
	/**
	 * 转为boolean,提供默认值
	 */
	public static boolean castBoolean(Object obj,boolean defaultValue){
		boolean booleanValue = defaultValue;
		if(obj!=null){
			booleanValue = Boolean.parseBoolean(castString(obj));
		}
		return booleanValue;
	}
}
