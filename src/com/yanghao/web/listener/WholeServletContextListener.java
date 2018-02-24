package com.yanghao.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ServeletContextȫ�ּ���������
 * @author YanoHao
 *
 */
public class WholeServletContextListener implements ServletContextListener {
	

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		

	}

	@Override
	public void contextInitialized(ServletContextEvent sc) {
		System.out.println("��ʼ��servletContext");
		//����һ��������������������Է����������������еķ��ʴ���
		ServletContext servletContext = sc.getServletContext();
		servletContext.setAttribute("requestCount", 0);
		//����һ�������û��������������浱ǰ�����������ߵ��û�
		servletContext.setAttribute("onlineUsers", 0);
		//����һ���ѵ�½�û��������������浱ǰ���������ѵ�½���û�
		servletContext.setAttribute("loginUsers", 0);
	}

}
