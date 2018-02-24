package com.yanghao.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yanghao.bean.User;
import com.yanghao.service.UserService;
import com.yanghao.utils.CookieUtil;


public class UserLoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("utf-8");
//		resp.setCharacterEncoding("utf-8");
		
//		resp.setCharacterEncoding("utf-8");
//		resp.setHeader("Content-Type", "text/html;charset=utf-8");
		
		resp.setContentType("text/html;charset=utf-8");
		
		
		String usernameString = req.getParameter("username");
		String passwordString = req.getParameter("password");
		String rememberString = req.getParameter("remember");
		String vCodeString = req.getParameter("vCode");
		UserService userService = new UserService();
		
		//用户登录
		User user = userService.dologin(usernameString, passwordString);
		//获取已经存在的Session对象
		HttpSession session = req.getSession();
		String code = (String)session.getAttribute("validateCode");
		
		if(vCodeString.equalsIgnoreCase(code))
		{
			if(user!=null)
			{
				System.out.println("登录成功");
				//如果登录成功，获取Session对象保存用户名和密码，代表用户已经在服务端登录
				session.setAttribute("user", user);
				
				//如果用户选择了记住用户名，则返回一个Cookie
				if(rememberString != null)
				{
					//服务端创建一个Cookie对象，用于保存用户名，返回给用户使用的浏览器
					Cookie cookie = CookieUtil.createCookie("username", usernameString, 7*24*60*60, req.getContextPath(),req);
					resp.addCookie(cookie);
				}
				else
				{
					resp.addCookie(CookieUtil.createNormalCookie("username", null, 0));
				}
				
				resp.sendRedirect("view/index.jsp");
			}
			else 
			{
				resp.sendRedirect("error.jsp");
			}
		}
		else
		{
			System.out.println("验证码错误");
			req.setAttribute("vCode", "error");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		
		
	}
	
}
