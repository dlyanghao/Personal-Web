package com.yanghao.service;

import javax.servlet.http.HttpSession;

import com.yanghao.bean.User;
import com.yanghao.dao.UserDao;
import com.yanghao.serviceinterface.UserServiceInterface;

public class UserService implements UserServiceInterface{
	
	
	//�û���¼����
	@Override
	public User dologin(String username, String password){
		
		UserDao userLoginDao = new UserDao();
		User user = userLoginDao.login(username, password);
		return user;
		
	}
	//�û��ǳ�����
	@Override
	public void outlogin(HttpSession session){
		
		session.removeAttribute("user");
		session.invalidate();
		
	}
	
	//��ѯע����û����Ƿ����
	@Override
	public boolean checkRegisterName(String registerName) {
		UserDao userDao = new UserDao();
		boolean flag = userDao.checkRegisterNameIsExist(registerName);

		return flag;
	}
	

}
