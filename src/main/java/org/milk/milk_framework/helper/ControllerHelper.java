package org.milk.milk_framework.helper;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.milk.milk_framework.annotation.Action;
import org.milk.milk_framework.bean.Handler;
import org.milk.milk_framework.bean.Request;
import org.milk.milk_framework.util.ArrayUtil;
import org.milk.milk_framework.util.CollectionUtil;

/**
 *@author �ﳬ��
 *@date 2016��2��21������8:01:05
 *����:������������
 */
public final class ControllerHelper {
	/**
	 * ���ڴ�������봦������ӳ���ϵ(���Action Map)
	 */
	private static final Map<Request,Handler> ACTION_MAP = new HashMap<>();
	static{
		//��ȡ���е�Controller��
		Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
		if(CollectionUtil.isNotEmpty(controllerClassSet)){
			//����Controller
			for(Class<?>controllerClass:controllerClassSet){
				//��ȡController�еķ���
				Method[]methods = controllerClass.getDeclaredMethods();
				if(ArrayUtil.isNotEmpty(methods)){
					//����Controller�еķ���
					for(Method method:methods){
						//�жϵ�ǰ�����Ƿ����Actionע��
						if(method.isAnnotationPresent(Action.class)){
							//��Actionע���л�ȡURLӳ�����
							Action action = method.getAnnotation(Action.class);
							String mapping = action.value();
							//��֤URLӳ�����
							if(mapping.matches("\\w+:/\\w*")){
								String[] array = mapping.split(":");
								if(ArrayUtil.isNotEmpty(array)&&array.length==2){
									//��ȡ���󷽷�������·��
									String requestMethod = array[0];
									String requestPath = array[1];
									Request request = new Request(requestMethod,requestPath);
									Handler handler = new Handler(controllerClass, method);
									//��ʼ��Action Map
									ACTION_MAP.put(request, handler);
								}
							}
						}
					}
				}
			}
		}
	}
	/**
	 * ��ȡHandler
	 */
	public static Handler getHandler(String requestMethod,String requestPath){
		Request request = new Request(requestMethod, requestPath);
		return ACTION_MAP.get(request);
	}
}
