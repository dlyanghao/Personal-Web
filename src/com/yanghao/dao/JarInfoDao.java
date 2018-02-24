package com.yanghao.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.yanghao.bean.JarFile;
import com.yanghao.daointerface.JarInfoDaoInterface;
import com.yanghao.utils.DatabaseUtil;
import com.yanghao.utils.IsEmptyForVar;

public class JarInfoDao implements JarInfoDaoInterface{
	/**
	 * 获取Jarinfo的所有查询结果
	 */
	@Override
	public List<JarFile> getAllInfo() {
		QueryRunner queryRunner = new QueryRunner(DatabaseUtil.getC3p0Poor());
		String sql="select * from jarinfo";
		try {
			List<JarFile> list = queryRunner.query(sql, new BeanListHandler<>(JarFile.class));
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addOneInfo(JarFile jar) {
		QueryRunner queryRunner = new QueryRunner(DatabaseUtil.getC3p0Poor());
		String sql = "insert into jarinfo values(null,?,?,?,?)";
		Object[] params = {jar.getName(),jar.getModule(),jar.getDescription(),jar.getUpdateTime()};
		try {
			if(IsEmptyForVar.isEmpty(jar.getName())||IsEmptyForVar.isEmpty(jar.getModule())){
				return false;
			}
			queryRunner.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public void deleteOneInfo(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOneInfo(JarFile jar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<JarFile> getPageInfo(int pageDataNumber, int currentPage) {
		
		QueryRunner queryRunner = new QueryRunner(DatabaseUtil.getC3p0Poor());
		String sql="select * from jarinfo limit ?,?";
		Object[] parmas = {(currentPage-1)*pageDataNumber,pageDataNumber};
		try {
			List<JarFile> result = queryRunner.query(sql, new BeanListHandler<>(JarFile.class),parmas);
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}


}
