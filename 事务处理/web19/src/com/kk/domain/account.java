package com.kk.domain;

public class account {
	private int uid;
	private int money;
	private String uname;
	
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	@Override
	public String toString() {
		return "account [uid=" + uid + ", money=" + money + ", uname=" + uname + "]";
	}
	
	
	
}
