package com.yanghao.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class WholeRequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void requestInitialized(ServletRequestEvent sr) {
		//每次服务器接受到请求就给计数器加一
		ServletContext servletContext = sr.getServletContext();
		int count = (int)servletContext.getAttribute("requestCount");
		servletContext.setAttribute("requestCount", ++count);
	}

}
