package com.yanghao.service;

import java.util.List;

import com.yanghao.bean.JarFile;
import com.yanghao.bean.JarFilesPage;
import com.yanghao.dao.JarInfoDao;

public class JarInfoService {
	
	//获取所有的Jar包信息
	public List<JarFile> getJarInfo(){
		
		List<JarFile> allInfo = new JarInfoDao().getAllInfo();
		
		return allInfo;
		
	}
	//获取分页bean JarFilesPage
	public JarFilesPage getPageInfo(int pageDataNumber,int currentPage){
		
		JarInfoDao jarInfoDao = new JarInfoDao();
		List<JarFile> pageInfo = jarInfoDao.getPageInfo(pageDataNumber, currentPage);
		List<JarFile> allInfo = jarInfoDao.getAllInfo();

		/**
		 * 封装一个JarFilesPage返回
		 */
		JarFilesPage jarFilesPage = new JarFilesPage();
		jarFilesPage.setAllDataNumber(allInfo.size());
		jarFilesPage.setCurrentPage(currentPage);
		jarFilesPage.setList(pageInfo);
		jarFilesPage.setPageDataNumber(pageDataNumber);
		
		int flag = allInfo.size()%pageDataNumber;
		int	pageNumber = allInfo.size()/pageDataNumber;
		if(flag==0){
			jarFilesPage.setPageNumber(pageNumber);	
		}
		else {
			jarFilesPage.setPageNumber(pageNumber+1);
		}
		
		return jarFilesPage;
	}
	
	//添加一个Jar信息
	
	public boolean addJar(JarFile jar){
		JarInfoDao jarInfoDao = new JarInfoDao();
		boolean flag = jarInfoDao.addOneInfo(jar);
		return flag;

	}
	
	
	

}
