package com.hxzy.dao;

import java.util.List;

import com.hxzy.bean.Phone;

public interface PhoneDao extends CommonDao<Phone> {
	/**
	 * 查询所有手机信息
	 * @return
	 */
	List<Phone> queryAll();
}
