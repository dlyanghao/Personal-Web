package com.yanghao.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class DownloadFileService {
	
	
	//返回当前项目download文件夹路径下的所有文件的文件名
	public List<String> getAllFilesName(String path){
		
		File file = new File(path);
		String[] arr = file.list();
		List<String> asList = Arrays.asList(arr);
		return asList;
	}
	
	//获取当前用户选择的文件的输入流对象
	
	public InputStream getFileInputStream(String rootPath,String filename){
		
		String path = rootPath+"/download/"+filename;
		System.out.println(path);
		
		try {
			BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(new File(path)));
			return inputStream;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
