package com.hxzy.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.hxzy.bean.User;
import com.hxzy.biz.UserBiz;
import com.hxzy.biz.impl.UserBizImpl;

public class UserBizImplTest {

	@Test
	public void testLogin() {
		UserBiz biz = new UserBizImpl();
		User user = biz.login("admin", "123");
		System.out.println(user);
		assertNotNull(user);
	}

}
