package com.kk.domain;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public  class PoolRedisUtil {
	static Properties pro =null;
	static {
		 pro = new Properties();
		InputStream inputStream = PoolRedisUtil.class.getClassLoader().getResourceAsStream("redis.properties");
		try {
			pro.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JedisPoolConfig poolconfig = new JedisPoolConfig();
		
	}
	
	@Test
	public void test1(){
		PoolRedisUtil p = new PoolRedisUtil();
		System.out.println(p.pro.get("add"));
	}
}
