package com.hxzy.biz;

import com.hxzy.bean.User;

public interface UserBiz extends CommonBiz<User>{
	User login(String account,String loginPwd);
	/**
	 * 根据用户名验证用户是否已经存在
	 * @param account
	 * @return
	 */
	User validateAccount(String account);
}
