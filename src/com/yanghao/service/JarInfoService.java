package com.yanghao.service;

import java.util.List;

import com.yanghao.bean.JarFile;
import com.yanghao.bean.JarFilesPage;
import com.yanghao.dao.JarInfoDao;

public class JarInfoService {
	
	//��ȡ���е�Jar����Ϣ
	public List<JarFile> getJarInfo(){
		
		List<JarFile> allInfo = new JarInfoDao().getAllInfo();
		
		return allInfo;
		
	}
	//��ȡ��ҳbean JarFilesPage
	public JarFilesPage getPageInfo(int pageDataNumber,int currentPage){
		
		JarInfoDao jarInfoDao = new JarInfoDao();
		List<JarFile> pageInfo = jarInfoDao.getPageInfo(pageDataNumber, currentPage);
		List<JarFile> allInfo = jarInfoDao.getAllInfo();

		/**
		 * ��װһ��JarFilesPage����
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
	
	//���һ��Jar��Ϣ
	
	public boolean addJar(JarFile jar){
		JarInfoDao jarInfoDao = new JarInfoDao();
		boolean flag = jarInfoDao.addOneInfo(jar);
		return flag;

	}
	
	
	

}
