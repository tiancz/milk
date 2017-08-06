package org.milk.milk_framework.proxy;

import java.lang.reflect.Method;

import org.milk.milk_framework.annotation.Transaction;
import org.milk.milk_framework.helper.DatabaseHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *@author �ﳬ��
 *@date 2016��3��9������10:20:09
 *@����:�������
 */
public class TransactionProxy implements Proxy {
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionProxy.class);
	
	private static final ThreadLocal<Boolean> FLAG_HOLDER = new ThreadLocal<Boolean>(){
		protected Boolean initialValue(){
			return false;
		}
	};

	@Override
	public Object doProxy(ProxyChain proxyChain) throws Throwable {
		Object result;
		boolean flag = FLAG_HOLDER.get();
		Method method = proxyChain.getTargetMethod();
		if(!flag&&method.isAnnotationPresent(Transaction.class)){
			FLAG_HOLDER.set(true);
			try{
				DatabaseHelper.beginTransaction();
				LOGGER.debug("begin transaction");
				result = proxyChain.doProxyChain();
				DatabaseHelper.commitTransaction();
				LOGGER.debug("commit transaction");
			}catch(Exception e){
				DatabaseHelper.rollbackTransaction();
				LOGGER.debug("rollback transaction");
				throw e;
			}finally{
				FLAG_HOLDER.remove();
			}
		}else{
			result = proxyChain.doProxyChain();
		}
		return result;
	}

}
