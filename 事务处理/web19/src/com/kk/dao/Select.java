package com.kk.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.kk.domain.account;
import com.kk.utils.MyDateSourceUtil;

public class Select {
	public static account selectForName(String uname) throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "select * from account where uname = ?";
		account account = qr.query(MyDateSourceUtil.getCurrentConnection(), sql,new BeanHandler<account>(account.class));
		return account;
	}
}
