package com.yanghao.bean;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Sun公司为我们解决使用装饰者模式装饰HTTPServletRequest时的不便而为我们写了HttpServletRequestWrapper类方便我们使用
 * @author YanoHao
 *
 */
public class RequestWapper extends HttpServletRequestWrapper {

	private HttpServletRequest request;
	
	public RequestWapper(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	
	@Override
	public String getParameter(String name) {
		/**
		 * 统一解决GET/POST请求乱码问题
		 */
		String result = "";
		
		if(request.getMethod().equalsIgnoreCase("POST"))
		{
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return request.getParameter(name);
		}
		
		if(request.getMethod().equalsIgnoreCase("GET")){
			String value = request.getParameter(name);
			//这里如果不判断直接在JSP页面获取参数的值的时会出现JspServletWrapper.handleJspException异常，原因是jsp页面接收了从后台传送过来的NULL的值所导致
			try {
				if(value!=null)
				{
					byte[] tem = value.getBytes("ISO-8859-1");
					result = new String(tem, "utf-8");
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}




	

}

