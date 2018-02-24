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

		System.out.println("��ʼ����");
		session = request.getSession();
		String filename= request.getParameter("downfilename");
		//String rootPath = getServletContext().getRealPath("");
		//System.out.println("rootPath  :"+rootPath);

		//�����������ļ���������������͹��������ĵ��ַ���ISO-8859-1���룩�ڷ��������������
		//byte[] bytes = filename.getBytes("ISO-8859-1");
		//filename = new String(bytes,"UTF-8");
		
		//System.out.println(filename);
		
		//ͨ������·����ȡ�ļ���������
		//DownAndUpFileService downAndUpFileService = new DownAndUpFileService();
		//InputStream fileInputStream = downAndUpFileService.getFileInputStream(rootPath, filename);
		
		//ͨ��ServletContextͨ�����·����ȡһ��������������ʹ�����·����Ϊ�������ͨ��getRealpath�����Ŀ�ĸ�·����
		ServletContext servletContext = getServletContext();
		InputStream fileInputStream = servletContext.getResourceAsStream("download/"+filename);
		//��ȡ��ǰ�����ļ��ĳ���,����ҳ����㵱ǰ���ؽ���
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
		
		System.out.println("��Ϊ��");
		
		//ͨ��response���ͻ���һ�����ص��������Ҫ����Ӧͷ�������ĵ�ֵ��Ҫ���д�����Ϊ��Ӧͷ���ܴ�����ģ����ǿ��Դ��Ӣ�ģ���ʱҪ�������ĵ�Ӣ�ĵ�ת�������õķ�ʽ��Base64��URLEncoder
		//��������ֻ��Base64���뷽ʽ�����������ֻ��URLEncoder���뷽ʽ
		String agent = request.getHeader("User-Agent");
		if(agent.contains("Firefox"))
		{
			//������ǻ����ʹ��URLEncoder����
			filename = EncoderUtil.getEnglishByURLEncoder(filename, "UTF-8");
		}
		else
		{
			//����ǻ��ʹ��base64����
			filename = EncoderUtil.getEnglishByBase64(filename, "UTF-8");
		}
		//���͸��ͻ��˵�������ʾ��
		response.setHeader("Content-Disposition", "attachment;filename="+filename);
		//ͨ��response�������д���ݸ��ͻ���
		ServletOutputStream outputStream = response.getOutputStream();
		
		writeFileData(request,fileInputStream, outputStream);
		
		
	
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	//ͨ�����ķ�ʽд����
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
	 * ʹ��Base64�������ļ���ת����Ӣ��
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
