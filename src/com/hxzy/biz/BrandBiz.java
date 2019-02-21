package com.hxzy.biz;

import java.util.List;

import com.hxzy.bean.Brand;

public interface BrandBiz extends CommonBiz<Brand> {
	/**
	 * 查询所有的品牌
	 * @return
	 */
	List<Brand> queryAll();
}
