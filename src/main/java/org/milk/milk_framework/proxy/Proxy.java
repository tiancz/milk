package org.milk.milk_framework.proxy;
/**
 *@author �ﳬ��
 *@date 2016��3��4������10:30:50
 *����:����ӿ�
 */
public interface Proxy {
	/**
	 * ִ����ʽ����
	 */
	Object doProxy(ProxyChain proxyChain) throws Throwable;

}
