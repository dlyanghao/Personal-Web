package com.yanghao.dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.yanghao.bean.User;
import com.yanghao.daointerface.UserDaoInterface;
import com.yanghao.utils.DatabaseUtil;

public class UserDao implements UserDaoInterface {
	
	
	/** 
	 * �û���½
	 */
	@Override
	public User login(String username,String password) {
		
		DataSource c3p0Poor = DatabaseUtil.getC3p0Poor();
		QueryRunner queryRunner = new QueryRunner(c3p0Poor);
		String sql = "select * from user where username=? and password=?";
		Object[] params = {username,password};
		User user = null;
		try {
			user = queryRunner.query(sql, new BeanHandler<>(User.class), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	/**
	 * ��ѯע����û����Ƿ����
	 * @param registerName
	 * @return
	 */
	public boolean checkRegisterNameIsExist(String registerName) {
		
		QueryRunner queryRunner = new QueryRunner(DatabaseUtil.getC3p0Poor());
		String sql = "select * from user where username=?";
		boolean flag = true;
		try {
			User user = queryRunner.query(sql, new BeanHandler<>(User.class), registerName);
			if(user!=null)
			{
				flag = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
}
