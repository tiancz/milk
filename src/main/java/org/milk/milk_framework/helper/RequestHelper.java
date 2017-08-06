package org.milk.milk_framework.helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.milk.milk_framework.bean.FormParam;
import org.milk.milk_framework.bean.Param;
import org.milk.milk_framework.util.ArrayUtil;
import org.milk.milk_framework.util.CodecUtil;
import org.milk.milk_framework.util.StreamUtil;
import org.milk.milk_framework.util.StringUtil;

/**
 *@author �ﳬ��
 *@date 2016��3��10������9:41:37
 *@����:����������
 */
public final class RequestHelper {
	//
	public static Param createParam(HttpServletRequest request)throws IOException{
		List<FormParam> formParamList = new ArrayList<>();
		formParamList.addAll(parseParameterNames(request));
		formParamList.addAll(parseInputStream(request));
		return new Param(formParamList);
	}
	private static List<FormParam> parseParameterNames(HttpServletRequest request){
		List<FormParam> formParamList = new ArrayList<>();
		Enumeration<String> paramNames = request.getParameterNames();
		while(paramNames.hasMoreElements()){
			String fieldName = paramNames.nextElement();
			String[]fieldValues = request.getParameterValues(fieldName);
			if(ArrayUtil.isNotEmpty(fieldValues)){
				Object fieldValue;
				if(fieldValues.length==1){
					fieldValue = fieldValues[0];
				}else{
					StringBuilder sb = new StringBuilder("");
					for(int i=0;i<fieldValues.length;i++){
						sb.append(fieldValues[i]);
						if(i!=fieldValues.length-1){
							sb.append(StringUtil.SEPARATOR);
						}
					}
					fieldValue = sb.toString();
				}
				formParamList.add(new FormParam(fieldName, fieldValue));
			}
		}
		return formParamList;
	}
	private static List<FormParam> parseInputStream(HttpServletRequest request) throws IOException {
		List<FormParam> formParamList = new ArrayList<>();
		String body = CodecUtil.decodeURL(StreamUtil.getString(request.getInputStream()),"UTF-8");
		if(body!=null){
			String[] kvs = StringUtil.splitString(body,"&");
			if(ArrayUtil.isNotEmpty(kvs)){
				for(String kv:kvs){
					String[]array = StringUtil.splitString(kv,"=");
					if(ArrayUtil.isNotEmpty(array)&&array.length==2){
						String fieldName = array[0];
						String fieldValue = array[1];
						formParamList.add(new FormParam(fieldName, fieldValue));
					}
				}
			}
		}
		return formParamList;
	}

}
