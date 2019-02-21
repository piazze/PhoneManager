package com.hxzy.biz.impl;

import com.hxzy.bean.User;
import com.hxzy.biz.UserBiz;
import com.hxzy.dao.UserDao;
import com.hxzy.dao.impl.UserDaoImpl;

public class UserBizImpl implements UserBiz {

	private UserDao dao = new UserDaoImpl();
	
	@Override
	public int add(User t) {
		return dao.add(t);
	}

	@Override
	public int update(User t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User queryOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User login(String account, String loginPwd) {
		return dao.login(account, loginPwd);
	}

	@Override
	public User validateAccount(String account) {
		return dao.validateAccount(account);
	}

}
