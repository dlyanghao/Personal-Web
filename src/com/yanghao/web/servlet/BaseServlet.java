package com.yanghao.web.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet{

	/**
	 * ��Ҫ���в����жϵ�����Servletʹ�÷�����з����ĵ���
	 * �Է����ķ���ֵ��һ����������Ƿ���null,�����κβ���������ǵ�ַ������·�������������ת��
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String methodName = req.getParameter("method");
		//��ȡ����ֽ����ļ����󣨵��ø÷������࣬һ���Ǹ�������ࣩ
		Class<? extends BaseServlet> clazz = this.getClass();
		try {
			//��ȡ���еķ�������
			Method method = clazz.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			//���÷���
			String returnValue = (String) method.invoke(this, req,resp);
			//�ж��Ƿ�Ҫ����ת��
			if(returnValue!=null){
				req.getRequestDispatcher(returnValue).forward(req, resp);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
