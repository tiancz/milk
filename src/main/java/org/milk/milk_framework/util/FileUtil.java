package org.milk.milk_framework.util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *@author �ﳬ��
 *@date 2016��3��11������10:12:52
 *@����:�ļ�����������
 */
public final class FileUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(FileUtil.class);
//	��ȡ�ļ���ʵ����ȥ��·����
	public static String getRealFileName(String fileName){
		return FilenameUtils.getName(fileName);
	}
//	�����ļ�
	public static File createFile(String filePath){
		File file;
		try{
			file = new File(filePath);
			File parentDir = file.getParentFile();
			if(!parentDir.exists()){
				FileUtils.forceMkdir(parentDir);
			}
		}catch(Exception e){
			LOGGER.error("create file failure", e);
			throw new RuntimeException(e);
		}
		return file;
	}

}
