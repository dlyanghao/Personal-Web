package com.yanghao.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * (封装c3p0连接池来创建数据库工具类)
 * 
 * @author YanoHao
 *
 */
public class DatabaseUtil {
	/**
	 * c3p0连接池对象的引用
	 */
	private static DataSource c3p0Poor;

	/**
	 * 创建一次
	 */
	static {
		// 直接创建连接池对象（自动加载配置文件，无需设置参数）
		c3p0Poor = new ComboPooledDataSource();
		// 通过工厂的方式创建连接池对象
		// try {
		// DataSource unpooledDataSource = DataSources.unpooledDataSource();
		// c3p0Poor = DataSources.pooledDataSource(unpooledDataSource);
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	/**
	 * 获取连接对象
	 * 
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {

		Connection connection = c3p0Poor.getConnection();
		System.out.println("通过c3p0连接池获取连接对象成功");
		return connection;
	}

	/**
	 * 关闭资源
	 */
	// 关闭建立的连接对象，释放资源
	public static void closeSourceConnection(Connection connection, Statement statement, ResultSet resultSet) {

		try {
			if (connection != null) {
				connection.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static DataSource getC3p0Poor() {
		return c3p0Poor;
	}
}
