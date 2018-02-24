package com.yanghao.daointerface;

import com.yanghao.bean.User;

public interface UserDaoInterface {
	
	public User login(String username,String password);
	
}
