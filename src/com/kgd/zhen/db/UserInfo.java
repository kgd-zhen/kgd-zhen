package com.kgd.zhen.db;

public class UserInfo {

	public int _id;
	public String name;
	public String email;
	public int age;
	public String info;
	public UserInfo()
	{
		
	}
	
	public UserInfo(String name, String email, int age, String info)
	{
		this.name = name;
		this.email = email;
		this.age = age;
		this.info = info;
	}
}
