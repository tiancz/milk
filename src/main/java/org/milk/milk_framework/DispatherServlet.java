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
 *@author �ﳬ��
 *@date 2016��2��21������8:39:51
 *����:����ת����
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/*",loadOnStartup = 0)
public class DispatherServlet extends HttpServlet {
	public void init(ServletConfig servletConfig) throws ServletException{
		//��ʼ�����Helper��
		HelperLoader.init();
		//��ȡServletContext����(����ע��Servlet)
		ServletContext servletContext = servletConfig.getServletContext();
		//ע�ᴦ��JSP��Servlet
		registerServlet(servletContext);
		UploadHelper.init(servletContext);
	}

	private void registerServlet(ServletContext servletContext){
		ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
		jspServlet.addMapping("/index.jsp");
		jspServlet.addMapping(ConfigHelper.getAppJspPath()+"*");
		
		//ע�ᴦ��̬��Դ��Ĭ��Servlet
		ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
		defaultServlet.addMapping("/favicon.ico");
		defaultServlet.addMapping(ConfigHelper.getAppAssetPath()+"*");
	}
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		//��ʼ��ServletHelper
		ServletHelper.init(request, response);
		try{
			//��ȡ���󷽷�������·��
			String requestMethod = request.getMethod().toLowerCase();
			String requestPath = request.getPathInfo();
			//��ȡAction������
			Handler handler = ControllerHelper.getHandler(requestMethod, requestPath);
			if(handler!=null){
				//��ȡController�༰��Beanʵ��
				Class<?> controllerClass = handler.getControllerClass();
				Object controllerBean = BeanHelper.getBean(controllerClass);
				Param param;
				if(UploadHelper.isMultipart(request)){
					param = UploadHelper.createParam(request);
				}else{
					param = RequestHelper.createParam(request);
				}
				
				/**
				 
				//���������������
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
				//����Action����
				Method actionMethod = handler.getActionMethod();
				Object result;
				if(param.isEmpty()){
					result = ReflectionUtil.invokeMethod(controllerBean, actionMethod);
				}else{
					result = ReflectionUtil.invokeMethod(controllerBean, actionMethod, param);
				}
				//����Action��������ֵ
				if(result instanceof View){
					//����JSPҳ��
					handleViewResult((View)result, request, response);
				}else if(result instanceof Data){
					//����JSON����
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
