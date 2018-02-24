package com.yanghao.service;

import javax.servlet.http.HttpSession;

import com.yanghao.bean.User;
import com.yanghao.dao.UserDao;
import com.yanghao.serviceinterface.UserServiceInterface;

public class UserService implements UserServiceInterface{
	
	
	//用户登录服务
	@Override
	public User dologin(String username, String password){
		
		UserDao userLoginDao = new UserDao();
		User user = userLoginDao.login(username, password);
		return user;
		
	}
	//用户登出服务
	@Override
	public void outlogin(HttpSession session){
		
		session.removeAttribute("user");
		session.invalidate();
		
	}
	
	//查询注册的用户名是否存在
	@Override
	public boolean checkRegisterName(String registerName) {
		UserDao userDao = new UserDao();
		boolean flag = userDao.checkRegisterNameIsExist(registerName);

		return flag;
	}
	

}
