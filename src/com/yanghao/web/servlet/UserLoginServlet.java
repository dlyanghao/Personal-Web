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
		
		//�û���¼
		User user = userService.dologin(usernameString, passwordString);
		//��ȡ�Ѿ����ڵ�Session����
		HttpSession session = req.getSession();
		String code = (String)session.getAttribute("validateCode");
		
		if(vCodeString.equalsIgnoreCase(code))
		{
			if(user!=null)
			{
				System.out.println("��¼�ɹ�");
				//�����¼�ɹ�����ȡSession���󱣴��û��������룬�����û��Ѿ��ڷ���˵�¼
				session.setAttribute("user", user);
				
				//����û�ѡ���˼�ס�û������򷵻�һ��Cookie
				if(rememberString != null)
				{
					//����˴���һ��Cookie�������ڱ����û��������ظ��û�ʹ�õ������
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
			System.out.println("��֤�����");
			req.setAttribute("vCode", "error");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		
		
	}
	
}
