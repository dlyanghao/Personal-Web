package com.yanghao.bean;

import java.util.List;

public class JarFilesPage {
	
	
	//单页的bean对象的List集合
	private List<JarFile> list;
	//总数据条数
	private int allDataNumber;
	//每一页的数据条数
	private int pageDataNumber;
	//当前是几页
	private int currentPage;
	//总共分成多少页
	private int pageNumber;
	
	
	public List<JarFile> getList() {
		return list;
	}
	public void setList(List<JarFile> list) {
		this.list = list;
	}
	public int getAllDataNumber() {
		return allDataNumber;
	}
	public void setAllDataNumber(int allDataNumber) {
		this.allDataNumber = allDataNumber;
	}
	public int getPageDataNumber() {
		return pageDataNumber;
	}
	public void setPageDataNumber(int pageDataNumber) {
		this.pageDataNumber = pageDataNumber;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	@Override
	public String toString() {
		return "JarFilesPage [list=" + list + ", allDataNumber=" + allDataNumber + ", pageDataNumber=" + pageDataNumber
				+ ", currentPage=" + currentPage + ", pageNumber=" + pageNumber + "]";
	}

}
