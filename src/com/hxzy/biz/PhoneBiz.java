package com.hxzy.biz;

import java.util.List;

import com.hxzy.bean.Phone;

public interface PhoneBiz extends CommonBiz<Phone> {

	/**
	 * 查询所有手机信息
	 * @return
	 */
	List<Phone> queryAll();
}
