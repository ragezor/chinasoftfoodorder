package com.neu.foodorder.utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

/**
 * 实现图片上传的工具类
 * @author 
 *
 */
public class FileLoadUtils {
	
	private static String localPath="D:/upload";
	
	/**
	 * 
	 * @param mf 文件
	 * @param prefix 前缀
	 * @return
	 */
	public static String upload(MultipartFile mf,String prefix) {
		String newFileName=UUID.randomUUID().toString().replaceAll("-", "")+"_"+mf.getOriginalFilename();
		String dirPath=localPath+"/"+prefix;
		File file=new File(dirPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		//System.out.println(dirPath+"------------------");
		try {
			mf.transferTo(new File(dirPath+"/"+newFileName));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prefix+"/"+newFileName;
	}
	/**
	 * 删除图片
	 * @param path
	 */
	public static void removePic(String path) {
		String target=localPath+"/"+path;
		//System.out.println(target);
		File file=new File(target);
		if(file.exists())file.delete();
	}

}
