package com.yanghao.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.yanghao.bean.RequestWapper;
/**
 * 专门解决请求乱码问题的过滤器
 * @author YanoHao
 *
 */
public class ResourveCodeFileter implements Filter{

	@Override
	public void destroy() {
	
		
	}

	@Override
	public void doFilter(ServletRequest sreq, ServletResponse sresp, FilterChain fc)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) sreq;
		RequestWapper requestWapper = new RequestWapper(request);
		fc.doFilter(requestWapper, sresp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}



}
