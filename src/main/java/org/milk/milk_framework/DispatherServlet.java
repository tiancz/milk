package org.milk.milk_framework;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.milk.milk_framework.bean.Data;
import org.milk.milk_framework.bean.Handler;
import org.milk.milk_framework.bean.Param;
import org.milk.milk_framework.bean.View;
import org.milk.milk_framework.helper.BeanHelper;
import org.milk.milk_framework.helper.ConfigHelper;
import org.milk.milk_framework.helper.ControllerHelper;
import org.milk.milk_framework.helper.RequestHelper;
import org.milk.milk_framework.helper.ServletHelper;
import org.milk.milk_framework.helper.UploadHelper;
import org.milk.milk_framework.util.JsonUtil;
import org.milk.milk_framework.util.ReflectionUtil;

/**
 *@author 田超哲
 *@date 2016年2月21日下午8:39:51
 *功能:请求转发器
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/*",loadOnStartup = 0)
public class DispatherServlet extends HttpServlet {
	public void init(ServletConfig servletConfig) throws ServletException{
		//初始化相关Helper类
		HelperLoader.init();
		//获取ServletContext对象(用于注册Servlet)
		ServletContext servletContext = servletConfig.getServletContext();
		//注册处理JSP的Servlet
		registerServlet(servletContext);
		UploadHelper.init(servletContext);
	}

	private void registerServlet(ServletContext servletContext){
		ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
		jspServlet.addMapping("/index.jsp");
		jspServlet.addMapping(ConfigHelper.getAppJspPath()+"*");
		
		//注册处理静态资源的默认Servlet
		ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
		defaultServlet.addMapping("/favicon.ico");
		defaultServlet.addMapping(ConfigHelper.getAppAssetPath()+"*");
	}
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		//初始化ServletHelper
		ServletHelper.init(request, response);
		try{
			//获取请求方法与请求路径
			String requestMethod = request.getMethod().toLowerCase();
			String requestPath = request.getPathInfo();
			//获取Action处理器
			Handler handler = ControllerHelper.getHandler(requestMethod, requestPath);
			if(handler!=null){
				//获取Controller类及其Bean实例
				Class<?> controllerClass = handler.getControllerClass();
				Object controllerBean = BeanHelper.getBean(controllerClass);
				Param param;
				if(UploadHelper.isMultipart(request)){
					param = UploadHelper.createParam(request);
				}else{
					param = RequestHelper.createParam(request);
				}
				
				/**
				 
				//创建请求参数对象
				Map<String,Object> paramMap = new HashMap<>();
				Enumeration<String> paramNames = request.getParameterNames();
				while(paramNames.hasMoreElements()){
					String paramName = paramNames.nextElement();
					String paramValue = request.getParameter(paramName);
					paramMap.put(paramName, paramValue);
				}
				String body = CodecUtil.decodeURL(StreamUtil.getString(request.getInputStream()),"GBK");
				if(body!=null){
					String[] params = StringUtil.splitString(body,"&");
					if(ArrayUtil.isNotEmpty(params)){
						for(String param:params){
							String[]array = StringUtil.splitString(param,"=");
							if(ArrayUtil.isNotEmpty(array)&&array.length==2){
								String paramName = array[0];
								String paramValue = array[1];
								paramMap.put(paramName, paramValue);
							}
						}
					}
				}
				Param param = new Param(paramMap);
				/**
				 * */
				//调用Action方法
				Method actionMethod = handler.getActionMethod();
				Object result;
				if(param.isEmpty()){
					result = ReflectionUtil.invokeMethod(controllerBean, actionMethod);
				}else{
					result = ReflectionUtil.invokeMethod(controllerBean, actionMethod, param);
				}
				//处理Action方法返回值
				if(result instanceof View){
					//返回JSP页面
					handleViewResult((View)result, request, response);
				}else if(result instanceof Data){
					//返回JSON数据
					handleDataResult((Data)result, request, response);
				}
			}
		}finally{
			ServletHelper.destroy();
		}
	}
	private void handleViewResult(View view,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String path = view.getPath();
		if(path!=null){
			if(path.startsWith("/")){
				response.sendRedirect(request.getContextPath()+path);
			}else{
				Map<String,Object>model = view.getModel();
				for(Map.Entry<String, Object>entry:model.entrySet()){
					request.setAttribute(entry.getKey(), entry.getValue());
				}
				request.getRequestDispatcher(ConfigHelper.getAppJspPath()+path).forward(request, response);
			}
		}
	}
	private void handleDataResult(Data data,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		Object model = data.getModel();
		if(model!=null){
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			PrintWriter writer = response.getWriter();
			String json = JsonUtil.toJson(model);
			writer.write(json);
			writer.flush();
			writer.close();
		}
	}
}
