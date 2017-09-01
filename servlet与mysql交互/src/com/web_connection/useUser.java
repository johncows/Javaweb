package com.web_connection;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.user.user;

public class useUser {
	 private static ComboPooledDataSource datasource;
	
	static {
			  datasource  = new ComboPooledDataSource();
		}
		
	public static user checkUSer(String username, String password) throws SQLException {
		QueryRunner qr = new QueryRunner(datasource);
		String sql = "select * from user where username = ? and password = ?";
		
		user pp = (user) qr.query(sql, new BeanHandler(user.class), username,password);
		return pp;
	}

	public static int addUser(String username,String password) throws SQLException {
		QueryRunner qr = new QueryRunner(datasource);
		String sql = "insert into user values(?,?)";
		int i  = qr.update(sql, username,password);
		return i;
	}
}
