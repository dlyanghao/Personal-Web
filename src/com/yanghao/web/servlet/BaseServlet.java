package com.yanghao.web.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet{

	/**
	 * 对要进行操作判断的所有Servlet使用反射进行方法的调用
	 * 对方法的返回值做一个处理：如果是返回null,则不做任何操作，如果是地址或者是路径，则进行请求转发
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String methodName = req.getParameter("method");
		//获取类的字节码文件对象（调用该方法的类，一般是该类的子类）
		Class<? extends BaseServlet> clazz = this.getClass();
		try {
			//获取类中的方法对象
			Method method = clazz.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			//调用方法
			String returnValue = (String) method.invoke(this, req,resp);
			//判断是否要请求转发
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
