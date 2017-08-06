package org.milk.milk_framework;

import org.milk.milk_framework.helper.AopHelper;
import org.milk.milk_framework.helper.BeanHelper;
import org.milk.milk_framework.helper.ClassHelper;
import org.milk.milk_framework.helper.ControllerHelper;
import org.milk.milk_framework.helper.IocHelper;
import org.milk.milk_framework.util.ClassUtil;

/**
 *@author �ﳬ��
 *@date 2016��2��21������8:18:57
 *����:������Ӧ��Helper��
 */
public final class HelperLoader {
	public static void init(){
		Class<?>[] classList = {
				ClassHelper.class,
				BeanHelper.class,
				AopHelper.class,
				IocHelper.class,
				ControllerHelper.class
		};
		for(Class<?> cls:classList){
			ClassUtil.loadClass(cls.getName());
		}
	}

}
