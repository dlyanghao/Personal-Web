package com.yanghao.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yanghao.service.UserService;

public class UserRegisterNameValidateServlet extends HttpServlet {

	/**
	 *检测用户名是否重复
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String registerName = req.getParameter("testName");
		boolean flag = new UserService().checkRegisterName(registerName);
		PrintWriter writer = resp.getWriter();
		writer.print(flag);
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
