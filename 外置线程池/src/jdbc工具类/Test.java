package jdbc工具类;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import dbcp.*;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;


public class Test {
	public static void main(String[] args) throws SQLException {
		QueryRunner qs = new  QueryRunner(dbcp.getDataSource());
//		String sql = "update product set pid = '123' where pid = 'p001'";
//		System.out.println(qs.update(sql));

		String sql = "select  * from product";

		
		
		/*
		 * 设置一个类 来接受 查询的结果集参数
		 */
		
		List<product> ls = qs.query(sql, new BeanListHandler<product>(product.class));
		for(product pr : ls) {
			System.out.println(pr);
		}

		
		
		/*
		 * 以键值对 进行存储 
		 * 
		 */
		
//		List<Map<String, Object>> ls = qs.query(sql, new MapListHandler());
//		for(Map<String, Object> lo : ls) {
//			System.out.println(lo);
//		}
		
		/*
		 * 以字段来获取所需要的结果集
		 * 
		 */
		
//		List<Object> ls = qs.query(sql, new ColumnListHandler("pid"));
//		for(Object l :ls) {
//			System.out.println(l);
//		}
		
	
	}
}
