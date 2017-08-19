package jdbc单链接;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
	public static void main(String [] args) throws Exception {
		Connection con = Dbutil.getConnection();

		
		/* 获取执行语句 使用 Statement 如果用于判断 则可能存在 sql 注入问题 ，一般情况下均使用预编译命令来	
		*	执行连接
		*
		*/
		
		Statement st = con.createStatement();
		String sql = "select * from product";
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			System.out.println(rs.getString(1) + " "+ rs.getString("pid") );
		}
			
		
		
		
		
		
		
	}
}
