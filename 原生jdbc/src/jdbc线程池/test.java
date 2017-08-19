package jdbc线程池;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class test {
	public static void main(String[] args) throws SQLException {
		DataSource ds = new MydataSource();
		Connection con = ds.getConnection();
		Statement st = con.createStatement();
		String sql = "select * from product";
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			System.out.println(rs.getString(1) + " "+ rs.getString("pid") );
		}
		
		rs.close();
		st.close();
		con.close();
	}
}
