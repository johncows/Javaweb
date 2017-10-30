package com.kk.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.kk.domain.User;
import com.kk.utils.DatasourceUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class UserSerachDao {

	public boolean SerachforName(String name) throws SQLException {
		QueryRunner runner = new QueryRunner(DatasourceUtil.getDataSource());
		String sql = "select * from user where name = ?";
		User query = runner.query(sql,new BeanHandler<User>(User.class),name);
		if(query==null) {
			return false;
		}
		return true;
	}

}
