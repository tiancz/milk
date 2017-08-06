package org.milk.milk_framework.helper;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *@author �ﳬ��
 *@date 2016��3��10������9:05:13
 *@����:servlet������
 */
public final class ServletHelper {
	private static final Logger LOGGER = LoggerFactory.getLogger(ServletHelper.class);
	
	private static final ThreadLocal<ServletHelper> SERVLET_HELPER_HOLDER = new ThreadLocal<>();
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private ServletHelper(HttpServletRequest request,HttpServletResponse response){
		this.request = request;
		this.response = response;
	}
	//��ʼ��
	public static void init(HttpServletRequest request,HttpServletResponse response){
		SERVLET_HELPER_HOLDER.set(new ServletHelper(request, response));
	}
	//����
	public static void destroy(){
		SERVLET_HELPER_HOLDER.remove();
	}
	//��ȡrequest����
	private static HttpServletRequest getRequest(){
		return SERVLET_HELPER_HOLDER.get().request;
	}
	//��ȡresponse����
	private static HttpServletResponse getResponse(){
		return SERVLET_HELPER_HOLDER.get().response;
	}
	//��ȡsession����
	private static HttpSession getSession(){
		return getRequest().getSession();
	}
	//��ȡServletContext����
	private static ServletContext getServletContext(){
		return getRequest().getServletContext();
	}
	//�����Է���request��
	public static void setRequestAttribute(String key,Object value){
		getRequest().setAttribute(key, value);
	}
	//��request�л�ȡ����
	@SuppressWarnings("unchecked")
	public static <T> T getRequestAttribute(String key){
		return (T)getRequest().getAttribute(key);
	}
	//��request���Ƴ�����
	public static void removeRequestAttribute(String key){
		getRequest().removeAttribute(key);
	}
	//�����ض�����Ӧ
	public static void sendRedirect(String location){
		try{
			getResponse().sendRedirect(getRequest().getContextPath()+location);
		}catch(IOException e){
			LOGGER.error("redirect failure", e);
		}
	}
	//�����Է���session��
	public static void setSessionAttribute(String key,Object value){
		getSession().setAttribute(key, value);
	}
	//��ȡsession�е�����
	@SuppressWarnings("unchecked")
	public static <T>T getSessionAttribute(String key){
		return (T)getRequest().getSession().getAttribute(key);
	}
	//�Ƴ�session�е�����
	public static void removeSessionAttribute(String key){
		getRequest().getSession().removeAttribute(key);
	}
	//ʧЧsession
	public static void invalidateSession(){
		getRequest().getSession().invalidate();
	}

}
