package com.kgd.zhen.service;

import com.kgd.zhen.bean.zhen_userBean;

/**
 *  用户相关sql接口
 * @author kgd.zhen@gmail.com
 *
 */
public interface userService {
	/**
	 * add userBean to zhen_userBean
	 * @param userBean
	 */
	public void addUser(zhen_userBean userBean);
	
}
