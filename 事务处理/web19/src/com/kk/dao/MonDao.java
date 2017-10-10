package com.kk.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.kk.domain.account;
import com.kk.utils.DatasourceUtil;

public class MonDao {

	public int trans(String user1, String user2, int money) {
		
		Connection con =null;
		try {
			con = DatasourceUtil.getConnection();
			QueryRunner qr = new QueryRunner();
			con.setAutoCommit(false);
			//启动事务
			String sql = "select * from account where uname = ?";
			account user_1 = qr.query(con, sql,new BeanHandler<account>(account.class),user1);
			
			int moneys =0;
			if(user_1==null) {
				return 4;//查无此人
			}
			if(((user_1.getMoney())-money)<0) {
				return 0;//个人金额不足
			}
			int temp_money = user_1.getMoney()-money;
			System.out.println(temp_money);
			
			
			sql = "update account set money = ? where uname = ?";
			if(qr.update(con, sql,temp_money,user1)==0) {
				con.rollback();
				return 1;
			}
			
			sql = "select * from account where uname = ?";
			account user_2 = qr.query(con, sql,new BeanHandler<account>(account.class),user2);
			if(user_2==null) {
				return 4;//查无此人
			}
			temp_money = user_2.getMoney()+money;
			System.out.println(temp_money);
			String sql2 = "update account set money = ? where uname = ?";
			if(qr.update(con,sql2,temp_money,user2)==0) {
				con.rollback();
				return 1;
			}
			
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 3;
	}
	

}
