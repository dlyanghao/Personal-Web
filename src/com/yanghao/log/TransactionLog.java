package com.yanghao.log;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet("/TransactionLog")
public class TransactionLog extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(TransactionLog.class);
	
	public TransactionLog(){
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		logger.debug("这是debug信息");
		logger.info("这是info信息");
		logger.error("这是error信息");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	
	

}
