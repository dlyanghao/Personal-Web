package com.yanghao.web.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.yanghao.utils.EncoderUtil;

import sun.misc.BASE64Encoder;

public class DownloadServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private HttpSession session;
	private Long fileLenth;


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("开始下载");
		session = request.getSession();
		String filename= request.getParameter("downfilename");
		//String rootPath = getServletContext().getRealPath("");
		//System.out.println("rootPath  :"+rootPath);

		//处理传过来的文件名，让浏览器发送过来的中文的字符（ISO-8859-1编码）在服务端能正常解码
		//byte[] bytes = filename.getBytes("ISO-8859-1");
		//filename = new String(bytes,"UTF-8");
		
		//System.out.println(filename);
		
		//通过绝对路径获取文件的输入流
		//DownAndUpFileService downAndUpFileService = new DownAndUpFileService();
		//InputStream fileInputStream = downAndUpFileService.getFileInputStream(rootPath, filename);
		
		//通过ServletContext通过相对路径获取一个输入流（可以使用相对路径因为该类可以通过getRealpath获得项目的根路径）
		ServletContext servletContext = getServletContext();
		InputStream fileInputStream = servletContext.getResourceAsStream("download/"+filename);
		//获取当前下载文件的长度,便于页面计算当前下载进度
		File file = new File(servletContext.getRealPath("download/"+filename));
		System.out.println(file.getPath());
		if(file.isFile())
		{
			fileLenth = file.length();
		}
		else
		{
			fileLenth = 10000l;
		}
		
		
		
		
		if(fileInputStream==null){
			return;
		}
		
		System.out.println("不为空");
		
		//通过response给客户端一个下载弹出框，如果要在响应头传入中文的值就要进行处理，因为响应头不能存放中文，但是可以存放英文，此时要进行中文到英文的转换，常用的方式有Base64和URLEncoder
		//火狐浏览器只有Base64解码方式，其他浏览器只有URLEncoder解码方式
		String agent = request.getHeader("User-Agent");
		if(agent.contains("Firefox"))
		{
			//如果不是火狐，使用URLEncoder编码
			filename = EncoderUtil.getEnglishByURLEncoder(filename, "UTF-8");
		}
		else
		{
			//如果是火狐使用base64编码
			filename = EncoderUtil.getEnglishByBase64(filename, "UTF-8");
		}
		//发送给客户端的下载提示框
		response.setHeader("Content-Disposition", "attachment;filename="+filename);
		//通过response的输出流写数据给客户端
		ServletOutputStream outputStream = response.getOutputStream();
		
		writeFileData(request,fileInputStream, outputStream);
		
		
	
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	//通过流的方式写数据
	private void writeFileData(HttpServletRequest request, InputStream fileInputStream, ServletOutputStream outputStream) throws IOException {
		int len=0;
		int outLen=0;
		byte[] buffer = new byte[1024];
		
		while((len=fileInputStream.read(buffer))!=-1){
			outputStream.write(buffer, 0, len);
			outLen+=len;
			int intValue = fileLenth.intValue();
			int bfb = (int) ((outLen*1.00/intValue)*100);
			session.setAttribute("downStatus", bfb);
		}
		
		outputStream.close();
		fileInputStream.close();
	}
	
	/**
	 * 使用Base64将中文文件名转换成英文
	 * @param fileName
	 * @return
	 */
	public String base64EncodeFileName(String fileName) {
		BASE64Encoder base64Encoder = new BASE64Encoder();
		try {
			return "=?UTF-8?B?"
					+ new String(base64Encoder.encode(fileName
							.getBytes("UTF-8"))) + "?=";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
