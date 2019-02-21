package com.hxzy.dao.impl;

import com.hxzy.bean.User;
import com.hxzy.dao.UserDao;
import com.hxzy.util.DataSourceUtil;

public class UserDaoImpl implements UserDao {

	private DataSourceUtil util = DataSourceUtil.getInstance();
	
	@Override
	public int add(User t) {
		String sql = "insert into user(account,loginpwd,role) values(?,?,?)";
		Object[] params = {t.getAccount(),t.getLoginPwd(),t.getRole()};
		return util.executeUpdate(sql, params);
	}

	@Override
	public int update(User t) {
		return 0;
	}

	@Override
	public int remove(int id) {
		return 0;
	}

	@Override
	public User queryOne(int id) {
		return null;
	}

	@Override
	public User login(String account, String loginPwd) {
		String sql = "select id,account,role from user where account=? and loginpwd=?";
		return util.queryOne(User.class, sql, account,loginPwd);
	}

	@Override
	public User validateAccount(String account) {
		String sql = "select  id,account,role from user where account=?";
		return util.queryOne(User.class, sql, account);
	}

}
