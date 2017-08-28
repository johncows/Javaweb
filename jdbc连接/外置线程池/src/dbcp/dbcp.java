package dbcp;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.management.RuntimeErrorException;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;


public class dbcp {
	static private DataSource dataSource;
	static {
		try {
		InputStream is = dbcp.class.getClassLoader().getResourceAsStream("db.properties");
		Properties pro = new Properties();
		pro.load(is);
		dataSource = BasicDataSourceFactory.createDataSource(pro);
		} catch (Exception e) {
			 throw new RuntimeException(e);
		}
	}
	
	public static DataSource getDataSource () {
		return dataSource;
	}
	
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	} 
	
	
	public static void  main(String[] args) throws SQLException {
		Connection con = dbcp.getConnection();
		/*
		 * 后面执行sql 语句
		 * 
		 * 
		 */
		
	}
		
	
}
