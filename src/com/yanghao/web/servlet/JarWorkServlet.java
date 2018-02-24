package com.yanghao.web.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.yanghao.bean.JarFile;
import com.yanghao.bean.JarFilesPage;
import com.yanghao.service.JarInfoService;


public class JarWorkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取请求参数do
		String operation = request.getParameter("do");
		//使用反射调用方法
		Class<? extends JarWorkServlet> clazz = this.getClass();
		try {
			Method method = clazz.getDeclaredMethod(operation, HttpServletRequest.class,HttpServletResponse.class);
			method.setAccessible(true);
			method.invoke(this, request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@SuppressWarnings("all")
	private void lookup(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		//设置每一页的显示数据的条数，以确定分页数
		int pageDataNumber = 12;
		JarFilesPage jarFilesPage = new JarInfoService().getPageInfo(pageDataNumber, currentPage);
		request.getSession().setAttribute("jarFilesPage", jarFilesPage);
		response.sendRedirect("view/jarinfo.jsp");
	}
	
	@SuppressWarnings("all")
	private void addjar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JarFile jarFile = new JarFile();
		String a = request.getParameter("name");
		System.out.println(a);
		Map<String, String[]> parameterMap = request.getParameterMap();
		BeanUtils.populate(jarFile, parameterMap);
		boolean flag = new JarInfoService().addJar(jarFile);
		if(flag){
			response.sendRedirect("view/jarinfo.jsp");
		}
		else
		{
			response.sendRedirect("error.jsp");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
