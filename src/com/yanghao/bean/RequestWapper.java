package com.yanghao.bean;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Sun��˾Ϊ���ǽ��ʹ��װ����ģʽװ��HTTPServletRequestʱ�Ĳ����Ϊ����д��HttpServletRequestWrapper�෽������ʹ��
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
		 * ͳһ���GET/POST������������
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
			//����������ж�ֱ����JSPҳ���ȡ������ֵ��ʱ�����JspServletWrapper.handleJspException�쳣��ԭ����jspҳ������˴Ӻ�̨���͹�����NULL��ֵ������
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

