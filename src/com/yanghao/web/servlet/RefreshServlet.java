package com.yanghao.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yanghao.service.DownloadFileService;

public class RefreshServlet extends HttpServlet {
	
	private ServletContext servletContext;
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	public void init() throws ServletException {
		List<String> downloadFileNames = getDownloadFileNames();
		servletContext.setAttribute("allFilesName", downloadFileNames);

	}


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<String> downloadFileNames = getDownloadFileNames();
		servletContext.setAttribute("allFilesName", downloadFileNames);
 
		
//		//解决乱码问题
//		response.setCharacterEncoding("utf-8");
//		response.setHeader("Content-Type", "text/html;charset=utf-8");
//		

		//response.sendRedirect("index.jsp");

		//RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
		//requestDispatcher.forward(request, response);

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	
	public List<String> getDownloadFileNames(){
		
		servletContext = getServletContext();
		String realPath = servletContext.getRealPath("/download");
		DownloadFileService downAndUpFileService = new DownloadFileService();
		List<String> allFilesName = downAndUpFileService.getAllFilesName(realPath);
		return allFilesName;
		
	}

}
