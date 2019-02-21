package com.hxzy.dao;

import java.util.List;

import com.hxzy.bean.Brand;

public interface BrandDao extends CommonDao<Brand> {

	/**
	 * 查询所有的品牌
	 * @return
	 */
	List<Brand> queryAll();
}
