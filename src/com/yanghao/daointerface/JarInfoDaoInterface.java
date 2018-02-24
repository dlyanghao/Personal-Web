package com.yanghao.daointerface;

import java.util.List;

import com.yanghao.bean.JarFile;

public interface JarInfoDaoInterface {
	
	public List<JarFile> getAllInfo();
	public List<JarFile> getPageInfo(int pageDataNumber,int currentPage);
	public boolean addOneInfo(JarFile jar);
	public void deleteOneInfo(int id);
	public void updateOneInfo(JarFile jar);

}
