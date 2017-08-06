package org.milk.milk_framework.bean;

/**
 *@author 田超哲
 *@date 2016年2月21日下午7:26:18
 *功能:封装请求信息
 */
public class Request {
	/**
	 * 请求方法
	 */
	private String requestMethod;
	/**
	 * 请求路径
	 */
	private String requestPath;
	
	public Request(String requestMethod,String requestPath){
		this.requestMethod = requestMethod;
		this.requestPath = requestPath;
	}

	public String getRequestMethod() {
		return requestMethod;
	}

	public String getRequestPath() {
		return requestPath;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((requestMethod == null) ? 0 : requestMethod.hashCode());
		result = prime * result + ((requestPath == null) ? 0 : requestPath.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Request other = (Request) obj;
		if (requestMethod == null) {
			if (other.requestMethod != null)
				return false;
		} else if (!requestMethod.equals(other.requestMethod))
			return false;
		if (requestPath == null) {
			if (other.requestPath != null)
				return false;
		} else if (!requestPath.equals(other.requestPath))
			return false;
		return true;
	}
//	@Override
//	public int hashCode() {
//		return requestMethod.hashCode()+requestPath.hashCode();
//	}
//	
//	@Override
//	public boolean equals(Object obj) {
//		return this.requestMethod.equals(((Request)obj).requestMethod)&&
//				this.requestPath.equals(((Request)obj).requestPath);
//	}
	
}
