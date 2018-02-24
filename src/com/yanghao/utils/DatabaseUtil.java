package com.yanghao.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * (��װc3p0���ӳ����������ݿ⹤����)
 * 
 * @author YanoHao
 *
 */
public class DatabaseUtil {
	/**
	 * c3p0���ӳض��������
	 */
	private static DataSource c3p0Poor;

	/**
	 * ����һ��
	 */
	static {
		// ֱ�Ӵ������ӳض����Զ����������ļ����������ò�����
		c3p0Poor = new ComboPooledDataSource();
		// ͨ�������ķ�ʽ�������ӳض���
		// try {
		// DataSource unpooledDataSource = DataSources.unpooledDataSource();
		// c3p0Poor = DataSources.pooledDataSource(unpooledDataSource);
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	/**
	 * ��ȡ���Ӷ���
	 * 
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {

		Connection connection = c3p0Poor.getConnection();
		System.out.println("ͨ��c3p0���ӳػ�ȡ���Ӷ���ɹ�");
		return connection;
	}

	/**
	 * �ر���Դ
	 */
	// �رս��������Ӷ����ͷ���Դ
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
