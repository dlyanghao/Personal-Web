package com.yanghao.utils;

public class IsEmptyForVar {
	//判断这个变量是否为空或者是null
	
	public static boolean isEmpty(Object obj){
		
		if(obj==null||"".equals(obj))
		{
			return true;
		}
		return false;
	}

}
