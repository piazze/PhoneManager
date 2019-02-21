package com.hxzy.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.hxzy.bean.Brand;
import com.hxzy.biz.BrandBiz;
import com.hxzy.biz.impl.BrandBizImpl;

public class BrandBizImplTest {

	private BrandBiz biz = new BrandBizImpl();
	
	@Test
	@Ignore
	public void addTest() {
		Brand t = new Brand("锤子");
		int row = biz.add(t);
		assertEquals(1,row);//期望值为1，实际值为row
	}
	@Test
	@Ignore
	public void updateTest() {
		Brand brand = new Brand(6, "1+");
		int row = biz.update(brand);
		assertEquals(1,row);//期望值为1，实际值为row
	}
	@Test
	@Ignore
	public void removeTest() {
		int row = biz.remove(1);
		assertEquals(1,row);//期望值为1，实际值为row
	}
	
	@Test
	@Ignore
	public void queryOneTest() {
		int brandId = 1;
		Brand brand = biz.queryOne(brandId);
		assertNotNull("为找到编号为" + brandId +"的数据",brand);
	}
	
	@Test
	public void testQueryAll() {
		List<Brand> queryAll = biz.queryAll();
		//String jsonString = JSON.toJSONString(queryAll);
		//System.out.println(jsonString);
		assertNotEquals(0, queryAll.size());//我不期望0，实际值是集合的长度
	}
}
