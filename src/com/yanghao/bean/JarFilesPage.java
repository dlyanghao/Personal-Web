package com.yanghao.bean;

import java.util.List;

public class JarFilesPage {
	
	
	//��ҳ��bean�����List����
	private List<JarFile> list;
	//����������
	private int allDataNumber;
	//ÿһҳ����������
	private int pageDataNumber;
	//��ǰ�Ǽ�ҳ
	private int currentPage;
	//�ܹ��ֳɶ���ҳ
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
