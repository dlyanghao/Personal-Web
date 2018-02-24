package com.yanghao.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import sun.misc.BASE64Encoder;

public class EncoderUtil {
	
	
	//ʹ��Base64����ķ�ʽ������ת����Ӣ��
	public static String getEnglishByBase64(String chinaStr, String enc){
		
		BASE64Encoder base64Encoder = new BASE64Encoder();
		
		try {
			return "=?"+enc+"?B?"
					+ new String(base64Encoder.encode(chinaStr
							.getBytes(enc))) + "?=";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	//ʹ��URLEncoder�ı��뷽ʽ������ת����Ӣ��
	public static String getEnglishByURLEncoder(String chinaStr, String enc){
		try {
			 return URLEncoder.encode(chinaStr, enc);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	

}
