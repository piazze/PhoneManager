package com.hxzy.biz.impl;

import java.util.List;

import com.hxzy.bean.Brand;
import com.hxzy.bean.Phone;
import com.hxzy.biz.BrandBiz;
import com.hxzy.dao.BrandDao;
import com.hxzy.dao.impl.BrandDaoImpl;

public class BrandBizImpl implements BrandBiz {

	//引用数据访问层的对象
	private BrandDao dao = new BrandDaoImpl();
	
	@Override
	public int add(Brand t) {
		return dao.add(t);
	}

	@Override
	public int update(Brand t) {
		return dao.update(t);
	}

	@Override
	public int remove(int id) {
		return dao.remove(id);
	}

	@Override
	public Brand queryOne(int id) {
		return dao.queryOne(id);
	}

	@Override
	public List<Brand> queryAll() {
		return dao.queryAll();
	}

}
