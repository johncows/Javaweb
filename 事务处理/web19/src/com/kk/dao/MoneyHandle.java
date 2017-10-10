package com.kk.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.kk.domain.account;
import com.kk.utils.MyDateSourceUtil;

public class MoneyHandle{
	public static int ductMoney(account acc,int money) throws SQLException {
		QueryRunner qr = new QueryRunner();
		
		String sql = "update account set money = money-? where uname = ?";
		int status = qr.update(MyDateSourceUtil.getCurrentConnection(), sql,money,acc.getUname());
		
		return status;
		
	}
	
	public static int reChargeMoney(account acc,int money) throws SQLException {
		QueryRunner qr = new QueryRunner();
		
		String sql = "update account set money = money+? where uname = ?";
		int status = qr.update(MyDateSourceUtil.getCurrentConnection(), sql,money,acc.getUname());
		
		return status;
		
	}
	
	
}
