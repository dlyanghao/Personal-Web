package com.yanghao.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class DownloadFileService {
	
	
	//���ص�ǰ��Ŀdownload�ļ���·���µ������ļ����ļ���
	public List<String> getAllFilesName(String path){
		
		File file = new File(path);
		String[] arr = file.list();
		List<String> asList = Arrays.asList(arr);
		return asList;
	}
	
	//��ȡ��ǰ�û�ѡ����ļ�������������
	
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
