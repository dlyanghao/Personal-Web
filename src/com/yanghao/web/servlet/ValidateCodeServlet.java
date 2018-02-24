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
	 * ��֤�봦��Servlet
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//����һ��У�������
		ValidateCode validateCode = new ValidateCode(250, 43, 5, 10);
		//��ȡ���У����������ɵ���֤���ַ���
		String code = validateCode.getCode();
		//�ѵ�ǰ����֤���ַ������浽��ǰ�û���Session��
		HttpSession session = req.getSession();
		session.setAttribute("validateCode", code);
		//ͨ��response�������
		ServletOutputStream outputStream = resp.getOutputStream();
		validateCode.write(outputStream);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
