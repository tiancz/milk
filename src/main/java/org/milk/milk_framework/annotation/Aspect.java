package org.milk.milk_framework.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *@author �ﳬ��
 *@date 2016��3��4������10:26:10
 *����:����ע��
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
	/**
	 * ע��
	 */
	Class<? extends Annotation> value();
	
}
