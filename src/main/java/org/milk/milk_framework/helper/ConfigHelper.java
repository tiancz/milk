package org.milk.milk_framework.helper;

import java.util.Properties;

import org.milk.milk_framework.ConfigConstant;
import org.milk.milk_framework.util.PropsUtil;

/**
 *@author �ﳬ��
 *@date 2016��2��21������1:55:51
 *����:�����ļ�������
 */
public final class ConfigHelper {
	private static final Properties CONFIG_PROPS = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);
	
	/**
	 * ��ȡJDBC����
	 */
	public static String getJdbcDriver(){
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_DRIVER);
	}
	/**
	 * ��ȡJDBC URL
	 */
	public static String getJdbcUrl(){
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_URL);
	}
	/**
	 * ��ȡJDBC�û���
	 */
	public static String getJdbcUsername(){
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_USERNAME);
	}
	/**
	 * ��ȡJDBC����
	 */
	public static String getJdbcPassword(){
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_PASSWORD);
	}
	/**
	 * ��ȡӦ�û�������
	 */
	public static String getAppBasePackage(){
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_BASE_PACKAGE);
	}
	/**
	 * ��ȡӦ��JSP·��
	 */
	public static String getAppJspPath(){
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_JSP_PATH,"/WEB-INF/view/");
	}
	/**
	 * ��ȡӦ�þ�̬��Դ·��
	 */
	public static String getAppAssetPath(){
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_ASSET_PATH,"/asset/");
	}
//	��ȡ�ļ��ϴ�����
	public static int getAppUploadLimit(){
		return PropsUtil.getInt(CONFIG_PROPS, ConfigConstant.APP_UPLOAD_LIMIT,10);
	}
//	������������ȡString���͵�����ֵ
	public static String getString(String key){
		return PropsUtil.getString(CONFIG_PROPS, key);
	}
//	������������ȡint���͵�����ֵ
	public static int getInt(String key){
		return PropsUtil.getInt(CONFIG_PROPS, key);
	}
//	������������ȡboolean���͵�����ֵ
	public static boolean getBoolean(String key){
		return PropsUtil.getBoolean(CONFIG_PROPS, key);
	}

}
