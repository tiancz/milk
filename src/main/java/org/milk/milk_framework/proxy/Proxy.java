package org.milk.milk_framework.proxy;
/**
 *@author 田超哲
 *@date 2016年3月4日下午10:30:50
 *功能:代理接口
 */
public interface Proxy {
	/**
	 * 执行链式代理
	 */
	Object doProxy(ProxyChain proxyChain) throws Throwable;

}
