package c3p0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		ComboPooledDataSource datasource  = new ComboPooledDataSource();
		Connection con = datasource.getConnection();
		String sql = "select * from product where pid = ? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "p001");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString(1));
		}
		
		
		
		
		

	}

}
