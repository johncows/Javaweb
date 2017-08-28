package jdbc单链接;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Dbutil {
	
	
	
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	private static Connection con = null; 
	
	static 
	{
		try {
			
			// 1.获取键值对利用的是 ResourceBundle类来装载 db.properties文件,利用 get方式放的键值对	
			ResourceBundle rb = ResourceBundle.getBundle("db");
			url = rb.getString("url");
			user = rb.getString("user");
			password = rb.getString("password");

			// 2.注册驱动 五步
			Class.forName(rb.getString("Driver"));
			con = DriverManager.getConnection(url, user, password);
			/*
			 *	Statement st = con.createStatement();
			 *	st.executeQuery(sql);  查询语句   返回结果集
			 *	st.executeUpdate(sql); 更新语句  返回 更新的数
			 */
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return con;
	} 

}
