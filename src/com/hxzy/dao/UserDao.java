package com.hxzy.dao;

import com.hxzy.bean.User;

public interface UserDao extends CommonDao<User> {

	User login(String account,String loginPwd);
	
	/**
	 * 根据用户名验证用户是否已经存在
	 * @param account
	 * @return
	 */
	User validateAccount(String account);
}
