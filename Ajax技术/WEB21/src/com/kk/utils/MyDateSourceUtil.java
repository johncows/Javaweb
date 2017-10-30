package com.kk.utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class MyDateSourceUtil {
	//获得connection---------连接池中获取
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	//作为一个map key作为当前线程固定下来
	private static ThreadLocal<Connection> tl = new ThreadLocal<>();
	
	
	
	public static void startTranscation() throws SQLException {
		getCurrentConnection().setAutoCommit(false);
	}
	
	public static void commitTranscation() throws SQLException {
		getCurrentConnection().commit();
	}
	
	
	public static void rollbackTranscation() throws SQLException {
		getCurrentConnection().rollback();
	}
	public static Connection getCurrentConnection() throws SQLException {
		Connection conn = tl.get();
		if(conn==null) {
			conn = dataSource.getConnection();
			tl.set(conn);
		}
		return dataSource.getConnection();
	}
}
