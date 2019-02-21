package com.hxzy.biz.impl;

import java.util.List;

import com.hxzy.bean.Phone;
import com.hxzy.biz.PhoneBiz;
import com.hxzy.dao.PhoneDao;
import com.hxzy.dao.impl.PhoneDaoImpl;

public class PhoneBizImpl implements PhoneBiz {

	private PhoneDao dao = new PhoneDaoImpl();
	
	@Override
	public int add(Phone t) {
		int count = t.getCount() == 0 ? 1:t.getCount(); //如果用户没有指定库存数量，默认为1，否则使用用户指定的库存数量
		t.setCount(count);
		
		return dao.add(t);
	}

	@Override
	public int update(Phone t) {
		return dao.update(t);
	}

	@Override
	public int remove(int id) {
		return dao.remove(id);
	}

	@Override
	public Phone queryOne(int id) {
		return dao.queryOne(id);
	}

	@Override
	public List<Phone> queryAll() {
		return dao.queryAll();
	}

}
