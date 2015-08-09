package com.kgd.zhen.service.impl;

//import net.sqlcipher.database.SQLiteDatabase;

import android.database.sqlite.SQLiteDatabase;

import com.kgd.zhen.bean.zhen_userBean;
import com.kgd.zhen.db.DatabaseHelper;
import com.kgd.zhen.service.userService;

public class userServiceImpl implements userService{

	SQLiteDatabase db;
	DatabaseHelper helper;

	public userServiceImpl(SQLiteDatabase db, DatabaseHelper helper) {
		this.db = db;
		this.helper = helper;
	}
	
	@Override
	public void addUser(zhen_userBean userBean) {
		//TODO  addUser sql
	}

	@Override
	public void delUser(zhen_userBean userBean) {
		// TODO del user sql
		
	}

}
