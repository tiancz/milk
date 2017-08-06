package org.milk.milk_framework.helper;

import java.lang.reflect.Field;
import java.util.Map;

import org.milk.milk_framework.annotation.Inject;
import org.milk.milk_framework.util.ArrayUtil;
import org.milk.milk_framework.util.CollectionUtil;
import org.milk.milk_framework.util.ReflectionUtil;

/**
 *@author �ﳬ��
 *@date 2016��2��21������6:39:18
 *����:����ע��������
 */
public final class IocHelper {
	static{
		//��ȡ���е�Bean����Beanʵ��֮���ӳ���ϵ(���Bean Map)
		Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
		if(CollectionUtil.isNotEmpty(beanMap)){
			//����Bean Map
			for(Map.Entry<Class<?>, Object>beanEntry:beanMap.entrySet()){
				//��BeanMap�л�ȡBean����Beanʵ��
				Class<?>beanClass = beanEntry.getKey();
				Object beanInstance = beanEntry.getValue();
				//��ȡBean�ඨ������г�Ա����(���Bean Field)
				Field[]beanFields = beanClass.getDeclaredFields();
				if(ArrayUtil.isNotEmpty(beanFields)){
					//����Bean Field
					for(Field beanField:beanFields){
						//�жϵ�ǰBean Field�Ƿ����Injectע��
						if(beanField.isAnnotationPresent(Inject.class)){
							//��Bean Map�л�ȡBean Field��Ӧ��ʵ��
							Class<?> beanFieldClass = beanField.getType();
							Object beanFieldInstance = beanMap.get(beanFieldClass);
							if(beanFieldInstance!=null){
								//ͨ�������ʼ��BeanField��ֵ
								ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
							}
						}
					}
				}
			}
		}
	}
}
