package org.milk.milk_framework.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *@author 田超哲
 *@date 2016年3月4日下午10:26:10
 *功能:切面注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
	/**
	 * 注解
	 */
	Class<? extends Annotation> value();
	
}
