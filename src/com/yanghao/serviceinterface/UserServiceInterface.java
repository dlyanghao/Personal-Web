package com.yanghao.serviceinterface;

import javax.servlet.http.HttpSession;

import com.yanghao.bean.User;

public interface UserServiceInterface {
	
	public boolean checkRegisterName(String name);
	public User dologin(String username, String password);
	public void outlogin(HttpSession session);
	
	

}
