package com.yanghao.utils;

public class IsEmptyForVar {
	//�ж���������Ƿ�Ϊ�ջ�����null
	
	public static boolean isEmpty(Object obj){
		
		if(obj==null||"".equals(obj))
		{
			return true;
		}
		return false;
	}

}
