package com.kk.web;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kk.domain.people;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisTest {
	
	//基础jedis使用
	public void test1(){
		Jedis jedis = new Jedis("localhost",6379);
		jedis.set("username", "zhangsanfeng");
		System.out.println(jedis.get("username"));
	}
	
	//利用线程池进行存储
	public void test2(){
		// 1.创建redis的连接池
		JedisPoolConfig pool = new JedisPoolConfig();
		pool.setMaxIdle(30); //最大闲置数
		pool.setMaxIdle(10); //最小闲置数
		
		pool.setMaxIdle(50); //最大连接数
		
		JedisPool pools = new JedisPool(pool, "localhost", 6379);
		Jedis resource = pools.getResource();
		resource.set("鸡巴蛋", "好大");
		System.out.println(resource.get("鸡巴蛋"));
		
		resource.close();
	}
	
	
	// 利用json存取数据
	public void test3(){
		people peo = new people(15, "苍井空");
		Gson gs = new Gson();
		String s = gs.toJson(peo);
		System.out.println(s);
		people people = gs.fromJson(s, peo.getClass());
		System.out.println(people);
		
	}

}
