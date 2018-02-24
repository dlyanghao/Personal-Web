package com.yanghao.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import sun.misc.BASE64Decoder;

public class CookieUtil {
	
	
	
	public static Cookie createNormalCookie(String name, String value , int expiry)
	{
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(expiry);
		return cookie;
	}
	
	/*
	 *创建一个Cookie并返回
	 *Cookie的值是存放在响应头返回的，由于响应头不能存放中文，此时要进行处理
	 */
	public static Cookie createCookie(String name, String value, int expiry, String uri, HttpServletRequest request) {
		
		//不管value是不是中文，统一用URLdecoder或者Base64进行编码
		if(request!=null)
		{
			String agent = request.getHeader("User-Agent");
			if(agent.contains("Firefox")){
				if(value!=null)
				value = EncoderUtil.getEnglishByBase64(value, "UTF-8");
			}
			else
			{
				if(value!=null)
				value = EncoderUtil.getEnglishByURLEncoder(value, "UTF-8");
			}
		}
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(expiry);
		if(uri!=null)
		cookie.setPath(uri);
		return cookie;
	}
	
	/**
	 * 获取Cookie里面保存的值
	 */
	public static String getCookieValue(String name,HttpServletRequest request) {
		
		Cookie[] cookies = request.getCookies();
		String result=null;
		if(cookies != null){
			
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals(name))
				{
					if(request.getHeader("User-Agent").contains("Firefox"))
					{
						try {
							byte[] decodeBuffer = new BASE64Decoder().decodeBuffer(cookie.getValue());
							result = new String(decodeBuffer,"UTF-8");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else
					{
						try {
							result = URLDecoder.decode(cookie.getValue(), "UTF-8");
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}

		}
		
		return result;
	}

}
		