package org.milk.milk_framework.bean;

import java.io.InputStream;

/**
 *@author �ﳬ��
 *@date 2016��3��10������10:44:35
 *@����:��װ�ϴ��ļ�����
 */
public class FileParam {
	private String fieldName;
	private String fileName;
	private long fileSize;
	private String contentType;
	private InputStream inputStream;
	public FileParam(String fieldName, String fileName, long fileSize, String contentType, InputStream inputStream) {
		super();
		this.fieldName = fieldName;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.contentType = contentType;
		this.inputStream = inputStream;
	}
	public String getFieldName() {
		return fieldName;
	}
	public String getFileName() {
		return fileName;
	}
	public long getFileSize() {
		return fileSize;
	}
	public String getContentType() {
		return contentType;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	
}
