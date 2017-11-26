package com.kk.domain;

public class people {
	private int age;
	private String name;
	@Override
	public String toString() {
		return "people [age=" + age + ", name=" + name + "]";
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public people(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	
}
