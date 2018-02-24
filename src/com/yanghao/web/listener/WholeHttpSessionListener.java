package com.yanghao.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class WholeHttpSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent hse) {
		System.out.println("����Session��");
		ServletContext servletContext = hse.getSession().getServletContext();
		int count = (int)servletContext.getAttribute("onlineUsers");
		servletContext.setAttribute("onlineUsers", ++count);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent hse) {
		System.out.println("����Session��");
		ServletContext servletContext = hse.getSession().getServletContext();
		int count = (int)servletContext.getAttribute("onlineUsers");
		servletContext.setAttribute("onlineUsers", --count);

	}

}
