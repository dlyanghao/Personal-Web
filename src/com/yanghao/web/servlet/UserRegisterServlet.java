package com.yanghao.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;

import com.yanghao.utils.DatabaseUtil;

public class UserRegisterServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String registerNameString = req.getParameter("registerName");
		String registerPsdString = req.getParameter("registerPsd");
		String registerNickName = req.getParameter("registerNickName");
		
		//调用数据库工具类增加一条用户记录
		QueryRunner queryRunner = new QueryRunner(DatabaseUtil.getC3p0Poor());
		String sql = "insert into user values(?,?,?,?)";
		try {
			int successNum = queryRunner.update(sql, null,registerNameString,registerPsdString,registerNickName);
			if(successNum==1)
			{
				resp.sendRedirect("registerSuccess.jsp");
//				req.getRequestDispatcher("view/registerSuccess.jsp").forward(req, resp);
			}
			else
			{
				resp.sendRedirect("registerError.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);

	}
}
