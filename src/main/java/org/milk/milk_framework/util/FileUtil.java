package org.milk.milk_framework.util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *@author 田超哲
 *@date 2016年3月11日下午10:12:52
 *@功能:文件操作工具类
 */
public final class FileUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(FileUtil.class);
//	获取文件真实名（去掉路径）
	public static String getRealFileName(String fileName){
		return FilenameUtils.getName(fileName);
	}
//	创建文件
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
