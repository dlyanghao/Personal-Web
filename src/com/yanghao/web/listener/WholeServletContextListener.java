package com.yanghao.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ServeletContext全局监听器对象
 * @author YanoHao
 *
 */
public class WholeServletContextListener implements ServletContextListener {
	

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		

	}

	@Override
	public void contextInitialized(ServletContextEvent sc) {
		System.out.println("初始化servletContext");
		//创建一个请求计数器用来保存自服务器开启以来所有的访问次数
		ServletContext servletContext = sc.getServletContext();
		servletContext.setAttribute("requestCount", 0);
		//创建一个在线用户计数器用来保存当前服务器中在线的用户
		servletContext.setAttribute("onlineUsers", 0);
		//创建一个已登陆用户计数器用来保存当前服务器中已登陆的用户
		servletContext.setAttribute("loginUsers", 0);
	}

}
