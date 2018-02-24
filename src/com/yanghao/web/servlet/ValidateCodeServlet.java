package com.yanghao.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.dsna.util.images.ValidateCode;

public class ValidateCodeServlet extends HttpServlet{

	/**
	 * 验证码处理Servlet
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//创建一个校验码对象
		ValidateCode validateCode = new ValidateCode(250, 43, 5, 10);
		//获取这个校验码对象生成的验证码字符串
		String code = validateCode.getCode();
		//把当前的验证码字符串保存到当前用户的Session中
		HttpSession session = req.getSession();
		session.setAttribute("validateCode", code);
		//通过response的输出流
		ServletOutputStream outputStream = resp.getOutputStream();
		validateCode.write(outputStream);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
