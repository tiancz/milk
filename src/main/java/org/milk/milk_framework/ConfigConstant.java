package org.milk.milk_framework;
/**
 *@author 田超哲
 *@date 2016年2月21日下午12:45:54
 *功能:提供相关配置项常量
 */
public interface ConfigConstant {
	String CONFIG_FILE = "milk.properties";
	
	String JDBC_DRIVER = "milk.framework.jdbc.driver";
	String JDBC_URL = "milk.framework.jdbc.url";
	String JDBC_USERNAME = "milk.framework.jdbc.username";
	String JDBC_PASSWORD = "milk.framework.jdbc.password";
	
	String APP_BASE_PACKAGE = "milk.framework.app.base_package";
	String APP_JSP_PATH = "milk.framework.app.jsp_path";
	String APP_ASSET_PATH = "milk.framework.app.asset_path";
	String APP_UPLOAD_LIMIT = "milk.framework.app.upload_limit";

}
